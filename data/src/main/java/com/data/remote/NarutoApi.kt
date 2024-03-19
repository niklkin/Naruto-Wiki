package com.data.remote

import com.domain.models.get_all_characters_model.AllCharactersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NarutoApi(private val client: HttpClient) {
    suspend fun getAllCharacters(): Flow<AllCharactersResponse> = flow {
        emit(client.get("https://narutodb.xyz/api/character").body<AllCharactersResponse>())
    }.flowOn(Dispatchers.IO)

}