package com.appdev.all_in_android.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val gradientBrush = Brush.linearGradient(
    colors = listOf(Color(0xFF1F70C7), Color(0xFF7DF3FE), Color(0xFF887DFE), Color(0xFF7D97FE))
)

fun Modifier.gradientBorder() = border(
    width = 1.dp,
    brush = gradientBrush,
    shape = RoundedCornerShape(8.dp)
)