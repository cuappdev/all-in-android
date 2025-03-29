package com.appdev.all_in_android.ui.components.general

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.appdev.all_in_android.R

/**
 * Component card representing a contract
 */
@Composable
fun PlayerCard(
    playerName: String,
    playerNumber: Int,
    playerPosition: String,
    playerImageUrl: String,
    onClick: () -> Unit
) {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFF1F70C7), Color(0xFF7DF3FE), Color(0xFF887DFE), Color(0xFF7D97FE))
    )
    Column(
        modifier = Modifier
            .width(103.dp)
            .height(131.dp)
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
            .clickable(
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImage(
            model = playerImageUrl,
            contentDescription = "player image",
            modifier = Modifier
                .size(50.dp)
                .border(1.dp, Color.White)
        )
        Text(
            text = playerName,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
        Text(
            text = "#$playerNumber | $playerPosition",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun PlayerCardPreview() {
    PlayerCard(
        playerName = "C. Manon",
        playerNumber = 14,
        playerPosition = "PG",
        playerImageUrl = ""
    ) {}
}

