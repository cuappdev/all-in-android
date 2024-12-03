package com.appdev.all_in_android.data.models

data class User (
    val id : Int,
    val username : String,
    val email : String,
    val balance : Double,
    val contracts : List<Contract>,
    val sellerTransactions : List<Transaction>,
    val buyerTransactions : List<Transaction>
)