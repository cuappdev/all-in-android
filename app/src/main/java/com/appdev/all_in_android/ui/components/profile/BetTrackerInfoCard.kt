package com.appdev.all_in_android.ui.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BetTrackerInfoCard(
    titleText: String,
    bodyText: String
) {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFF1F70C7), Color(0xFF7DF3FE), Color(0xFF887DFE), Color(0xFF7D97FE))
    )
    Box(
        modifier = Modifier
            .width(164.dp)
            .height(84.dp)
            .border(
                width = 1.dp,
                brush = gradientBrush,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = Color(0xFF201E2D),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = titleText,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = bodyText,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun BetTrackerInfoCardPreview() {
    BetTrackerInfoCard(
        titleText = "Age of Account",
        bodyText = "17 days"
    )
}