package com.appdev.all_in_android.data.repositories

import com.appdev.all_in_android.data.NetworkingService
import com.appdev.all_in_android.data.models.Player
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepository @Inject constructor(
    private val networkingService: NetworkingService
) {
    suspend fun getAllPlayers(): List<Player> {
        val response = networkingService.getAllPlayers()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw Exception("Failed to fetch players: ${response.code()}")
        }
    }
}
