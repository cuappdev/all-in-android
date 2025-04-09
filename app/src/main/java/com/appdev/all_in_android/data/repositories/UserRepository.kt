package com.appdev.all_in_android.data.repositories

import android.util.Log
import com.appdev.all_in_android.data.NetworkingService
import com.appdev.all_in_android.data.models.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val networkingService: NetworkingService
) {

    suspend fun getUserById(userId: Int): User? {
        val response = networkingService.getUserById(userId)
        Log.d("UserRepository", "getUserById: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to fetch user: ${response.code()}")
        }
    }

    suspend fun createUser(user: User): User? {
        val response = networkingService.createUser(user)
        Log.d("UserRepository", "createUser: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to create user: ${response.code()}")
        }
    }

    suspend fun updateUser(userId: Int, updates: Map<String, Any>): User? {
        val response = networkingService.updateUser(userId, updates)
        Log.d("UserRepository", "updateUser: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to update user: ${response.code()}")
        }
    }
}
