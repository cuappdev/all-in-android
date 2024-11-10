package com.appdev.all_in_android.data.models

data class PlayerData (
    val id : Int,
    val gameDate : String,
    val opposingTeam : University,
    val points : Int,
    val minutes : Int,
    val fieldGoals : Int,
    val threePointers : Int,
    val freeThrows : Int,
    val rebounds : Int,
    val assists : Int,
    val steals : Int,
    val blocks : Int,
    val turnovers : Int,
    val fouls : Int,
    val playerId : Int
)

enum class University {
    Lehigh,
    Morrisville,
    Fordham,
    George,
    Fullerton,
    Utah,
    Monmouth,
    Lafayette,
    Syracuse,
    Siena,
    Robert,
    Colgate,
    Baylor,
    Columbia,
    Penn,
    Brown,
    Wells,
    Princeton,
    Dartmouth,
    Harvard,
    Yale,
    Ohio
}
