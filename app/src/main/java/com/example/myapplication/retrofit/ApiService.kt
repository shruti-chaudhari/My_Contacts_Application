package com.example.myapplication.retrofit

import com.example.myapplication.dataclasses.UserData
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<UserData>
}
