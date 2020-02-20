package com.assignment.kotlinassignmentapp.di.module

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.assignment.kotlinassignmentapp.TodoApp
import com.assignment.kotlinassignmentapp.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideApplication(): TodoApp = TodoApp()

    @Provides
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory = factory

}