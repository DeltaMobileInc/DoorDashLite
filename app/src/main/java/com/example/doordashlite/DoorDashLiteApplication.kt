package com.example.doordashlite

import android.app.Application
import com.example.doordashlite.di.AppComponent
import com.example.doordashlite.di.DaggerAppComponent

class DoorDashLiteApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}