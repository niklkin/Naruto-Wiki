package com.domain.repository

import com.domain.models.get_all_characters_model.AllCharactersResponse
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    suspend fun getCharacters(): Flow<AllCharactersResponse>
}