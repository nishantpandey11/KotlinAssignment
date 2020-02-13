package com.assignment.kotlinassignmentapp.di.component

import android.app.Application
import com.assignment.kotlinassignmentapp.di.module.AppModule
import com.assignment.kotlinassignmentapp.di.module.NetworkModule
import com.assignment.kotlinassignmentapp.di.module.ViewModelFactoryModule
import com.assignment.kotlinassignmentapp.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ViewModelFactoryModule::class, NetworkModule::class, AppModule::class])
interface AppComponent {
    fun inject(app: MainActivity)


    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(application: Application): Builder
    }

}
