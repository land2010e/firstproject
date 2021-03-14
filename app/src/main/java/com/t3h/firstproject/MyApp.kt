package com.t3h.firstproject

import android.app.Application

class MyApp : Application() {
    var account: Account? = null

    override fun onCreate() {
        super.onCreate()

    }
}