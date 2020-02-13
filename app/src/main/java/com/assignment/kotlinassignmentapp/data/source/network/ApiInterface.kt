package com.assignment.kotlinassignmentapp.data.source.network

import com.assignment.kotlinassignmentapp.data.model.TodoModel
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiInterface {

    @GET("/todos")
    fun getTodoList(): Observable<List<TodoModel>>
}