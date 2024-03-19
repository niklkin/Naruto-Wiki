package com.data.repositories

import com.data.remote.NarutoApi
import com.domain.models.get_all_characters_model.AllCharactersResponse
import com.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow

class KtorNetworkRepository(
    private val narutoApi: NarutoApi
) : NetworkRepository {
    override suspend fun getCharacters(): Flow<AllCharactersResponse> =
        narutoApi.getAllCharacters()

}