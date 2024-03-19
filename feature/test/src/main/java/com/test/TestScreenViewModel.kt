package com.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.models.get_all_characters_model.AllCharactersResponse
import com.domain.repository.NetworkRepository
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
        networkRepository.getCharacters().collect {
            _state.value = state.value.copy(
                charactersResponse = it
            )
        }
    }

}

data class TestScreenState(
    val charactersResponse: AllCharactersResponse = AllCharactersResponse()
)