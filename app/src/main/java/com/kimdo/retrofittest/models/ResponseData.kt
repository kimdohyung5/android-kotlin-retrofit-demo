package com.kimdo.retrofittest.models

// https://jsonplaceholder.typicode.com/todos/1
data class ResponseData(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)