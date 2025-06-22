package com.widya.internetlistapp

import retrofit2.http.GET

interface ApiService {
    @GET("public/v2/users")
    suspend fun getUsers(): List<User>
}