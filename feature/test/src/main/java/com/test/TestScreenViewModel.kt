package com.test

import com.domain.repository.NetworkRepository
import com.example.core.utils.MviViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class TestScreenViewModel(
    private val networkRepository: NetworkRepository
) : MviViewModel<TestScreenState, Unit, TestScreenEvent>(initialState = TestScreenState()) {
    override fun onEvent(event: TestScreenEvent) {
        when (event) {
            TestScreenEvent.GetAllCharactersPaged -> getAllCharacters()
        }
    }

    init {
        onEvent(TestScreenEvent.GetAllCharactersPaged)
    }

    private fun getAllCharacters() = intent {
        networkRepository.getCharacters().let() {
            reduce {
                state.copy(
                    charactersPaged = it
                )
            }
        }
    }


}

