package com.domain.repository

import androidx.paging.PagingData
import com.domain.entity.get_all_characters_model.Character
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    suspend fun getCharacters(): Flow<PagingData<Character>>
}