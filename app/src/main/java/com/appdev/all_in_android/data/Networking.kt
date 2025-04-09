package com.appdev.all_in_android.data

import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.data.models.ContractCreateRequest
import com.appdev.all_in_android.data.models.Player
import com.appdev.all_in_android.data.models.Transaction
import com.appdev.all_in_android.data.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkingService {

    // USERS
    @GET("/users/")
    suspend fun getAllUsers(): Response<List<User>> // Shouldn't really be used

    @GET("/user/{user_id}/")
    suspend fun getUserById(@Path("user_id") userId: Int): Response<User>

    @POST("/users/")
    suspend fun createUser(@Body user: User): Response<User>

    @PATCH("/user/{user_id}/")
    suspend fun updateUser(
        @Path("user_id") userId: Int,
        @Body updates: Map<String, Any>
    ): Response<User>

    @DELETE("/user/{user_id}/")
    suspend fun deleteUser(@Path("user_id") userId: Int): Response<Unit> // Shouldn't really be used


    // CONTRACTS
    @GET("/contracts/")
    suspend fun getAllContracts(): Response<List<Contract>>

    @GET("/contract/{contract_id}/")
    suspend fun getContractById(@Path("contract_id") contractId: Int): Response<Contract>

    @POST("/contracts/")
    suspend fun createContract(@Body contract: ContractCreateRequest): Response<Contract>

    @PATCH("/contract/{contract_id}/")
    suspend fun updateContract(
        @Path("contract_id") contractId: Int,
        @Body updates: Map<String, Any>
    ): Response<Contract>

    @DELETE("/contract/{contract_id}/")
    suspend fun deleteContract(@Path("contract_id") contractId: Int): Response<Unit> // Shouldn't really be used

    @GET("/market/")
    suspend fun getContractsOnMarket(): Response<List<Contract>>

    @POST("/contract/{contract_id}/buy/")
    suspend fun buyContract(
        @Path("contract_id") contractId: Int,
        @Body buyerInfo: Map<String, Int> // e.g., { "buyer_user_id": 1 }
    ): Response<Contract>

    @POST("/contract/{contract_id}/sell/")
    suspend fun sellContract(
        @Path("contract_id") contractId: Int,
        @Body sellInfo: Map<String, Any> // e.g., { "sell_price": 1000 }
    ): Response<Contract>


    // TRANSACTIONS
    @GET("/transactions/")
    suspend fun getAllTransactions(): Response<List<Transaction>>


    // PLAYERS
    @GET("/players/")
    suspend fun getAllPlayers(): Response<List<Player>>
}

