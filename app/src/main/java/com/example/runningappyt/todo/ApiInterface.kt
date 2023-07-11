package com.example.runningappyt.todo

import retrofit2.http.GET

interface ApiInterface {
    @GET("todos")
    suspend fun getTodos(): GetTodosResponse?
}