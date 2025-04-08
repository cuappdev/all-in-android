package com.appdev.all_in_android.data.repositories

import android.util.Log
import com.appdev.all_in_android.data.NetworkingService
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.data.models.ContractCreateRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContractsRepository @Inject constructor(
    private val networkingService: NetworkingService
) {

    suspend fun getAllContracts(): List<Contract>? {
        val response = networkingService.getAllContracts()
        Log.d("ContractsRepository", "getAllContracts: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to fetch contracts: ${response.code()}")
        }
    }

    suspend fun getContractById(contractId: Int): Contract? {
        val response = networkingService.getContractById(contractId)
        Log.d("ContractsRepository", "getContractById: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to fetch contract: ${response.code()}")
        }
    }

    suspend fun createContract(contract: ContractCreateRequest): Contract? {
        val response = networkingService.createContract(contract)
        Log.d("ContractsRepository", "createContract: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to create contract: ${response.code()}")
        }
    }

    suspend fun updateContract(contractId: Int, updates: Map<String, Any>): Contract? {
        val response = networkingService.updateContract(contractId, updates)
        Log.d("ContractsRepository", "updateContract: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to update contract: ${response.code()}")
        }
    }

    suspend fun deleteContract(contractId: Int) {
        val response = networkingService.deleteContract(contractId)
        Log.d("ContractsRepository", "deleteContract: $response")
        if (!response.isSuccessful) {
            throw Exception("Failed to delete contract: ${response.code()}")
        }
    }

    suspend fun getContractsOnMarket(): List<Contract>? {
        val response = networkingService.getContractsOnMarket()
        Log.d("ContractsRepository", "getContractsOnMarket: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to fetch market contracts: ${response.code()}")
        }
    }

    suspend fun buyContract(contractId: Int, buyerInfo: Map<String, Int>): Contract? {
        val response = networkingService.buyContract(contractId, buyerInfo)
        Log.d("ContractsRepository", "buyContract: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to buy contract: ${response.code()}")
        }
    }

    suspend fun sellContract(contractId: Int, sellInfo: Map<String, Any>): Contract? {
        val response = networkingService.sellContract(contractId, sellInfo)
        Log.d("ContractsRepository", "sellContract: $response")
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Failed to sell contract: ${response.code()}")
        }
    }
}
