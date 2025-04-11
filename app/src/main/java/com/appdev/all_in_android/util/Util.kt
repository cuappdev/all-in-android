package com.appdev.all_in_android.util

import com.appdev.all_in_android.R
import com.appdev.all_in_android.data.models.Contract
import java.util.Locale
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

fun toDollarString(amount: Double, toInt: Boolean): String {
    val sign = if (amount >= 0) "+" else "-"
    val absoluteAmt = amount.absoluteValue
    val amountString = if (toInt) (absoluteAmt).roundToInt()
    else String.format(Locale.US, "%.2f", absoluteAmt)
    return "$sign$$amountString"
}

fun toCurrency(amount: Double): String {
    return String.format(Locale.US, "%.2f", amount)
}

fun firstInitialLastName(fullName: String): String {
    val names = fullName.split(" ")
    if (names.size < 2) {
        return fullName
    }
    val firstNameInitial = names[0].first().uppercase() + "."
    val lastName = names.last()
    return "$firstNameInitial $lastName"
}
val myFavoriteContract = Contract(
    id = "0",
    playerName = "Chris Manon",
    playerImageId = R.drawable.player_photo,
    opposingTeam = "UPenn",
    dateOfGame = "03/24",
    actionType = "Rebounds",
    actionQuantity = 4,
    cost = 1220.0,
    gain = 3240.0,
    sport = "Men's Basketball"
)