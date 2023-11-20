package com.withjetpack.dogtestapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DogTestApplication:Application (){
    override fun onCreate() {
        super.onCreate()
    }
}