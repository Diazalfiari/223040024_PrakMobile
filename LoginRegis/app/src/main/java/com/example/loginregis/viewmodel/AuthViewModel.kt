package com.example.loginregis.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginregis.data.model.LoginRequest
import com.example.loginregis.data.model.LoginResponse
import com.example.loginregis.data.model.RegisterRequest
import com.example.loginregis.data.model.RegisterResponse
import com.example.loginregis.data.network.RetrofitClient
import kotlinx.coroutines.launch
import kotlin.Result.Companion.failure

class AuthViewModel : ViewModel() {
    var loginState by mutableStateOf<Result<LoginResponse>?>(null)
    var registerState by mutableStateOf<Result<RegisterResponse>?>(null)

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.login(LoginRequest(email, password))
                loginState = Result.success(response)
            } catch (e: Exception) {
                loginState = failure(e)
            }
        }
    }

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.register(RegisterRequest(name, email, password))
                registerState = Result.success(response)
            } catch (e: Exception) {
                registerState = failure(e)
            }
        }
    }
}