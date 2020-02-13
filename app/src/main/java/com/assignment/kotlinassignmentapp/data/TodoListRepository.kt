package com.assignment.kotlinassignmentapp.data

import com.assignment.kotlinassignmentapp.data.source.network.ApiInterface
import com.assignment.kotlinassignmentapp.data.model.TodoModel
import io.reactivex.Observable

import javax.inject.Inject

class TodoListRepository @Inject constructor(private val apiInterface: ApiInterface) {

    fun getTodoList():Observable<List<TodoModel>>{
        return apiInterface.getTodoList()
    }
}