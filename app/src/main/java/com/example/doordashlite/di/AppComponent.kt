package com.example.doordashlite.di

import android.content.Context
import com.example.doordashlite.viewmodel.RestaurantViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(viewModel: RestaurantViewModel)
}