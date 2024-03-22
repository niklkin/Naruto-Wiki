package com.test

import androidx.paging.PagingData
import com.domain.entity.get_all_characters_model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


data class TestScreenState(
    val charactersPaged: Flow<PagingData<Character>> = flow { }
)

sealed interface TestScreenEvent {
    data object GetAllCharactersPaged : TestScreenEvent

}