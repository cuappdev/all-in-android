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