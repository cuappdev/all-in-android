package com.appdev.all_in_android.data.models

import com.appdev.all_in_android.R

data class Contract(
    val id: String,
    val playerName: String,
    val playerImageId: Int,
    val dateOfGame: String,
    val actionQuantity: Int,
    val actionType: String,
    val cost: Int,
    val gain: Int
)

data class ContractCreateRequest(
    val user_id: Int,
    val player_id: Int
)

object ContractRepo {
    val players = listOf(
        Contract(
            "111aaa",
            "Evan Williams",
            R.drawable.player_photo,
            "4/26/24",
            4,
            "FGA",
            1000,
            2400
        ),
        Contract(
            "222bbb",
            "Chris Manon",
            R.drawable.player_photo,
            "4/26/24",
            4,
            "FGA",
            1400,
            1600
        ),
        Contract(
            "333ccc",
            "Nazir Williams",
            R.drawable.player_photo,
            "4/26/24",
            4,
            "FGA",
            1000,
            2400
        ),
        Contract("444ddd",
            "Isaiah Gray",
            R.drawable.player_photo,
            "4/26/24",
            4,
            "FGA",
            1000,
            2400
        ),
        Contract("555eee",
            "Player Name",
            R.drawable.player_photo,
            "4/26/24",
            4,
            "FGA",
            1400,
            1600
        )
    )
}
