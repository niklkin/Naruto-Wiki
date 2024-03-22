package com.data.remote

import com.data.remote.dto.get_all_characters_dto.AllCharactersDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
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

suspend inline fun <reified T> HttpClient.getResults(
    block: HttpRequestBuilder.() -> Unit
): Result<T> = try {
    val response = request(block)
    if (response.status == HttpStatusCode.OK) {
        Result.Success(response.body())
    } else {
        Result.Error(Throwable("${response.status}: ${response.bodyAsText()}"))
    }
} catch (e: Exception) {
    Result.Error(e)
}

