package com.tolbier.gio

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileReader

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val role: Role
)

enum class Role{
    Admin,
    Regular
}

fun usersFromJSONFile(filename: String): List<User> {
    val gson = Gson()
    return gson.fromJson<List<User>>(FileReader(filename), object : TypeToken<List<User>>(){ }.type)
}