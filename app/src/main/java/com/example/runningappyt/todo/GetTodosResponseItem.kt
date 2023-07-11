package com.example.runningappyt.todo

data class GetTodosResponseItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)