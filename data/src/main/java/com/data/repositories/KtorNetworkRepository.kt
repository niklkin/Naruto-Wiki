package com.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.data.ResultPagingSource
import com.data.map
import com.data.remote.NarutoApi
import com.domain.models.get_all_characters_model.Character
import com.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow

class KtorNetworkRepository(
    private val narutoApi: NarutoApi
) : NetworkRepository {
    override suspend fun getCharacters(): Flow<PagingData<Character>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = {
                ResultPagingSource { page, _ ->
                    narutoApi.getAllCharactersPaged(page).map { it.characters }
                }
            }
        ).flow

}