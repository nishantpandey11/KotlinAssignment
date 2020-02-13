package com.assignment.kotlinassignmentapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.kotlinassignmentapp.di.ViewModelKey
import com.assignment.kotlinassignmentapp.viewmodel.MainViewModel
import com.assignment.kotlinassignmentapp.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindListViewModel(viewModel: MainViewModel): ViewModel
}