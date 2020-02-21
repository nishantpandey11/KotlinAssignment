package com.assignment.kotlinassignmentapp.data.source.network

import com.assignment.kotlinassignmentapp.data.model.TodoModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {

    @GET("/todos")
    suspend fun getTodo(): Response<List<TodoModel>>

}