package com.t3h.firstproject

data class Account(
    val username: String,
    val password: String = "Test",
    var age: Int
)