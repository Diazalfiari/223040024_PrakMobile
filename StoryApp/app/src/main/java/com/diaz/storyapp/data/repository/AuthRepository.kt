
package com.diaz.storyapp.repository

import com.diaz.storyapp.data.local.dao.UserDao
import com.diaz.storyapp.data.local.entity.UserEntity
import com.diaz.storyapp.data.remote.ApiService
import com.diaz.storyapp.data.remote.model.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton
import com.diaz.storyapp.data.helper.Result

@Singleton
class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {
    suspend fun login(email: String, password: String): Flow<Result<UserEntity>> = flow {
        emit(Result.Loading)
        try {
            val response = apiService.login(LoginRequest(email, password))
            if (response.error) {
                emit(Result.Error(response.message))
            } else {
                val user = UserEntity(
                    userId = response.loginResult.userId,
                    name = response.loginResult.name,
                    token = response.loginResult.token
                )
                userDao.insertUser(user)
                emit(Result.Success(user))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Terjadi kesalahan"))
        }
    }
}