package com.appdev.all_in_android.data

import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.data.models.Player
import com.appdev.all_in_android.data.models.Transaction
import com.appdev.all_in_android.data.models.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object PostApi {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://157.245.116.197:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val instance: NetworkingService by lazy {
        retrofit.create(NetworkingService::class.java)
    }
}

interface NetworkingService {
    @GET("/contracts/")
    suspend fun getAllContracts(): Response<List<Contract>>

    @GET("/users/")
    suspend fun getAllUsers(): Response<List<User>>

    @GET("/transactions/")
    suspend fun getAllTransactions(): Response<List<Transaction>>

    @GET("/players/")
    suspend fun getAllPlayers(): Response<List<Player>>
}
