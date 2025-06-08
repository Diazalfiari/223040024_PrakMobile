package com.diaz.storyapp.data.remote

import com.diaz.storyapp.data.remote.model.LoginRequest
import com.diaz.storyapp.data.remote.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    // Tambahkan endpoint lain di sini
}