package com.appdev.all_in_android.data.repositories

import android.util.Log
import com.appdev.all_in_android.data.NetworkingService
import com.appdev.all_in_android.data.models.Player
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepository @Inject constructor(
    private val networkingService: NetworkingService
) {
    suspend fun getAllPlayers(): List<Player>? {
        val response = networkingService.getAllPlayers()
        Log.d("PlayerRepository", "getAllPlayers: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to fetch players: ${response.code()}")
        }
    }
}
