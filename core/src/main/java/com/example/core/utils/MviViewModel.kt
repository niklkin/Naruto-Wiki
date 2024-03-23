package com.example.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

abstract class MviViewModel<STATE : Any, SIDE_EFFECT : Any, EVENT : Any>(initialState: STATE) :
    ViewModel(),
    ContainerHost<STATE, SIDE_EFFECT> {
    override val container: Container<STATE, SIDE_EFFECT> =
        viewModelScope.container<STATE, SIDE_EFFECT>(initialState = initialState)

    abstract fun onEvent(event: EVENT)

}