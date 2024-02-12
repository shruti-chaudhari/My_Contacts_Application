package com.example.myapplication.retrofit

import com.example.myapplication.dataclasses.UserData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun getUsers(): List<UserData> {
        return apiService.getUsers()
    }
}
