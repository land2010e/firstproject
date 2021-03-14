package com.t3h.firstproject

import android.app.Application
import android.util.Log

class MyApp : Application() {
    var account: Account? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("MyApp", "onCreate...........")
    }
}