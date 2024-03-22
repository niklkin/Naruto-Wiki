package com.test


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun TestScreen() {
    val viewModel = koinViewModel<TestScreenViewModel>()
    val state by viewModel.collectAsState()
    val characters by rememberUpdatedState(newValue = state.charactersPaged.collectAsLazyPagingItems())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (characters != null)
            items(characters!!.itemCount) { index ->
                val item = characters!![index]
                item?.let {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(11.dp))
                            .background(Color.LightGray),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "${it.name}")
                            SubcomposeAsyncImage(
                                modifier = Modifier
                                    .size(150.dp),
                                model = it.images.firstOrNull() ?: "",
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                error = {
                                    Icon(
                                        imageVector = Icons.Default.AccountCircle,
                                        contentDescription = null,
                                        modifier = Modifier.size(150.dp)
                                    )
                                },
                                loading = {
                                    CircularProgressIndicator()
                                }
                            )
                        }
                    }
                }
            }
        characters.loadState.apply {
            when {
                refresh is LoadState.NotLoading && characters!!.itemCount < 1 -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No Items",
                                modifier = Modifier.align(Alignment.Center),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                refresh is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                color = Color.Red
                            )
                        }
                    }
                }

                append is LoadState.Loading -> {
                    item {
                        CircularProgressIndicator(
                            color = Color.Red,
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(20.dp)
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }

                refresh is LoadState.Error -> {
                    item {
//                        ErrorView(
//                            message = "No Internet Connection.",
//                            onClickRetry = { characters!!.retry() },
//                            modifier = Modifier.fillMaxWidth(1f)
//                        )
                    }
                }

                append is LoadState.Error -> {
                    item {
//                        ErrorItem(
//                            message = "No Internet Connection",
//                            onClickRetry = { characters!!.retry() },
//                        )
                    }
                }
            }
        }

    }
}