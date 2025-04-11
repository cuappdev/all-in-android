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
import com.appdev.all_in_android.ui.theme.AllinandroidTheme
import com.appdev.all_in_android.ui.theme.gradientBorder

@Composable
fun BetTrackerInfoCard(
    titleText: String,
    bodyText: String
) {
    Column(
        modifier = Modifier
            .width(164.dp)
            .height(85.dp)
            .gradientBorder()
            .background(
                color = Color(0xFF201E2D),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = titleText,
            color = Color.White,
            fontSize = 12.sp,
            lineHeight = 12.sp,
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
    AllinandroidTheme {
        BetTrackerInfoCard(
            titleText = "No. of Contracts Sold",
            bodyText = "7"
        )
    }
}