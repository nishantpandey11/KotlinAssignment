package com.assignment.kotlinassignmentapp

import android.app.Application
import com.assignment.kotlinassignmentapp.di.component.AppComponent
import com.assignment.kotlinassignmentapp.di.component.DaggerAppComponent

class TodoApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

}