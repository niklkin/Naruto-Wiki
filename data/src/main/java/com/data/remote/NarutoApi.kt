package com.data.remote

import com.data.getResults
import com.data.remote.dto.get_all_characters_dto.AllCharactersDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NarutoApi(private val client: HttpClient) {
    suspend fun getAllCharacters(): Flow<AllCharactersDto> = flow {
        emit(client.get("https://narutodb.xyz/api/character").body<AllCharactersDto>())
    }.flowOn(Dispatchers.IO)

    suspend fun getAllCharactersPaged(page: Int = 0) = client.getResults<AllCharactersDto> {
        url("https://narutodb.xyz/api/character?page=${page}&limit=10")
        method = HttpMethod.Get
    }
}