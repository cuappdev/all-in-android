package com.appdev.all_in_android.util

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

fun firstInitialLastName(fullName: String): String {
    val names = fullName.split(" ")
    if (names.size < 2) {
        return fullName
    }
    val firstNameInitial = names[0].first().uppercase() + "."
    val lastName = names.last()
    return "$firstNameInitial $lastName"
}