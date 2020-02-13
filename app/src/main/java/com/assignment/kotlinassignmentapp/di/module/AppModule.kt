package com.assignment.kotlinassignmentapp.di.module

import android.app.Application
import android.content.Context
import com.assignment.kotlinassignmentapp.TodoApp
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideApplication(): TodoApp = TodoApp()

    @Provides
    fun provideContext(application: Application): Context = application

}