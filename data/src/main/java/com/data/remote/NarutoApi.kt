package com.data.remote

import com.data.remote.models.get_all_characters_model.AllCharactersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NarutoApi(private val client: HttpClient) {
    suspend fun getAllCharacters(): AllCharactersResponse {
        return client.get("https://narutodb.xyz/api/character").body<AllCharactersResponse>()
    }

}