package com.example.myapplication.di

import com.data.di.DataModule
import com.domain.di.DomainModule
import com.test.di.TestModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(): KoinApplication = startKoin {
    modules(
        DomainModule,
        DataModule,
        TestModule
    )

}