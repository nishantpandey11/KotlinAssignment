package com.assignment.kotlinassignmentapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.assignment.kotlinassignmentapp.R
import com.assignment.kotlinassignmentapp.TodoApp
import com.assignment.kotlinassignmentapp.databinding.ActivityMainBinding
import com.assignment.kotlinassignmentapp.view.adapter.TodoListAdapter
import com.assignment.kotlinassignmentapp.viewmodel.MainViewModel
import com.assignment.kotlinassignmentapp.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainViewModel
    private lateinit var mainBinding: ActivityMainBinding
    private val todoListAdapter = TodoListAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val app: TodoApp = application as TodoApp
        app.appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        mainBinding.recyclerView.adapter = todoListAdapter

        viewModel.todoListData.observe(this, Observer {
            todoListAdapter.submitList(it)
        })

    }
}
