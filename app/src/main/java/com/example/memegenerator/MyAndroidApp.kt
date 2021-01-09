package com.example.memegenerator

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyAndroidApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}