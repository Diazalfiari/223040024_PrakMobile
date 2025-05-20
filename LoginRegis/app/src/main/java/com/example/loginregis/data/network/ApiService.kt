package com.example.loginregis.data.network

import com.example.loginregis.data.model.LoginRequest
import com.example.loginregis.data.model.LoginResponse
import com.example.loginregis.data.model.RegisterRequest
import com.example.loginregis.data.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): RegisterResponse
}