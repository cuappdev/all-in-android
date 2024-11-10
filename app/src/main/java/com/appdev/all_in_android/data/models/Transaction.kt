package com.appdev.all_in_android.data.models

data class Transaction (
    val id : Int,
    val transactionDate : String,
    val price : Double,
    val sellerId : Int,
    val buyerId : Int,
    val contractId : Int
)