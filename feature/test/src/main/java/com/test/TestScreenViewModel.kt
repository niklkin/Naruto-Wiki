package com.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.domain.entity.get_all_characters_model.Character
import com.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TestScreenViewModel(
    private val networkRepository: NetworkRepository
) : ViewModel() {
    private val _state = MutableStateFlow(TestScreenState())
    val state = _state.asStateFlow()

    init {
        getAllCharacters()
    }

    fun getAllCharacters() = viewModelScope.launch {
        networkRepository.getCharacters().let {
            _state.value = state.value.copy(
                charactersPaged = it
            )
        }
    }

}

data class TestScreenState(
    val charactersPaged: Flow<PagingData<Character>>? = null
)