package com.appdev.all_in_android.data.models

data class Player (
    val id : Int,
    val firstName : String,
    val lastName : String,
    val position : List<Position>,
    val number : Int,
    val height : String,
    val weight : Int,
    val hometown : String,
    val highSchool : String,
    val contracts : List<Contract>,
    val playerData : List<PlayerData>
)

enum class Position{
    Guard, Forward, Center
}