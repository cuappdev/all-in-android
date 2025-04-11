package com.appdev.all_in_android.data.repositories

import android.util.Log
import com.appdev.all_in_android.data.NetworkingService
import com.appdev.all_in_android.data.models.Transaction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionsRepository @Inject constructor(
    private val networkingService: NetworkingService
) {

    suspend fun getAllTransactions(): List<Transaction>? {
        val response = networkingService.getAllTransactions()
        Log.d("TransactionsRepository", "getAllTransactions: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to fetch transactions: ${response.code()}")
        }
    }
}
