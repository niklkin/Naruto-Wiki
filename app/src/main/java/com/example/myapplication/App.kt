package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.initKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin().apply {
            androidContext(this@App)
        }
    }
}