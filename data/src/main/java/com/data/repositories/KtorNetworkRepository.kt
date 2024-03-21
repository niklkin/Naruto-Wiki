package com.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.data.ResultPagingSource
import com.data.map
import com.data.remote.NarutoApi
import com.data.remote.dto.get_all_characters_dto.toDomain
import com.domain.entity.get_all_characters_model.AllCharactersEntity
import com.domain.entity.get_all_characters_model.Character
import com.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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
                    narutoApi.getAllCharactersPaged(page)
                        .map { it.toDomain().characters }
                }
            }
        ).flow

    suspend fun getAllCharacters(): Flow<AllCharactersEntity> =
        narutoApi.getAllCharacters().map { it.toDomain() }

}