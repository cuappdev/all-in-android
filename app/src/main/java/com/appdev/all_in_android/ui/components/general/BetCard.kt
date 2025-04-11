package com.appdev.all_in_android.ui.components.general

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.theme.gradientBorder

@Composable
fun BetCard(
    title: String,
    date: String,
    sport: String,
    bettingLine: String,
    cost: Double,
    gain: Double,
    playerImageUrl: String = "",
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .gradientBorder()
            .background(
                color = Color(0xFF201E2D),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.player_photo),
                contentDescription = "player photo",
                modifier = Modifier
                    .width(37.dp)
                    .height(47.dp)
            )
            Spacer(Modifier.width(16.dp))
            BetCardInfoBody(title, date, sport, bettingLine)
        }
        Spacer(modifier = Modifier.width(12.dp))
        CostGainTextBody(cost, gain)
    }

}

@Composable
private fun BetCardInfoBody(
    title: String,
    date: String,
    sport: String,
    bettingLine: String
) {
    Column() {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$date | $sport",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = bettingLine,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}

@Composable
private fun CostGainTextBody(cost: Double, gain: Double) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Cost: $cost",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFF97066)
        )
        Text(
            text = "Gain: $gain",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF47CD89)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BetCardPreview() {
    BetCard(
        title = "Jake Shane v. Harvard",
        date = "03/24",
        sport = "Men's Hockey",
        bettingLine = "Scores first goal of game",
        cost = 20.00,
        gain = 40.00
    )
}