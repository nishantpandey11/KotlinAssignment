package com.assignment.kotlinassignmentapp.data


import com.assignment.kotlinassignmentapp.data.model.TodoModel
import com.assignment.kotlinassignmentapp.data.source.network.ApiInterface
import javax.inject.Inject

class TodoListRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getTodo(): List<TodoModel> {
        return apiInterface.getTodo()
    }

}