package com.test


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.koinViewModel

@Composable
fun TestScreen() {
    val viewModel = koinViewModel<TestScreenViewModel>()
    val state by viewModel.state.collectAsState()
    val characters by rememberUpdatedState(newValue = state.charactersPaged?.collectAsLazyPagingItems())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (characters != null)
            items(characters!!.itemCount) { index ->
                val item = characters!![index]
                item?.let { Text(text = "${it.name}") }
            }
        characters!!.loadState.apply {
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
                            modifier = Modifier.fillMaxSize().padding(20.dp),
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
                            modifier = Modifier.fillMaxWidth(1f)
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