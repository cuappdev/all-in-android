package com.appdev.all_in_android.ui.components.bet_tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.ui.theme.gradientBorder

@Composable
fun BetTrackerInfoCard(
    titleText: String,
    bodyText: String
) {
    Column(
        modifier = Modifier
            .width(164.dp)
            .height(84.dp)
            .gradientBorder()
            .background(
                color = Color(0xFF201E2D),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = titleText,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 12.sp
        )
        Text(
            text = bodyText,
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun BetTrackerInfoCardPreview() {
    BetTrackerInfoCard(
        titleText = "Age of Account",
        bodyText = "17 days"
    )
}