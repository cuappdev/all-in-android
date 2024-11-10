package com.appdev.all_in_android.data.models

data class Contract (
    val id: String,
    val playerName: String,
    val playearImageId: Int,
    val dateOfGame: String,
    val actionQuantity: Int,
    val actionType: String,
    val cost: Int,
    val gain: Int
)