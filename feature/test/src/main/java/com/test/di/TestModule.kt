package com.test.di

import com.test.TestScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val TestModule = module {
    viewModelOf(::TestScreenViewModel)
}