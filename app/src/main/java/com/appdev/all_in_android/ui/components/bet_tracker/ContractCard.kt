package com.appdev.all_in_android.ui.components.bet_tracker

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun ContractCard(
    contractTitle: String,
    contractDate: String,
    contractSport: String,
    contractLine: String,
    contractCost: Int,
    contractGain: Int,
    playerImageUrl: String = "",
    onClick: () -> Unit
) {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFF1F70C7), Color(0xFF7DF3FE), Color(0xFF887DFE), Color(0xFF7D97FE))
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .width(160.dp)
            .height(190.dp)
            .border(
                width = 1.dp,
                brush = gradientBrush,
                shape = RoundedCornerShape(13.dp)
            )
            .background(
                color = Color(0xFF201E2D),
                shape = RoundedCornerShape(13.dp)
            )
            .padding(12.dp)
            .clickable(
                onClick = onClick
            )
    ) {
        ContractHeaderContent(playerImageUrl, contractTitle, contractDate, contractSport)

        ContractBodyContent(gradientBrush, contractLine, contractCost, contractGain)
    }
}

@Composable
private fun ContractHeaderContent(
    playerImageUrl: String,
    contractTitle: String,
    contractDate: String,
    contractSport: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        AsyncImage(
            model = playerImageUrl,
            contentDescription = "player image",
            modifier = Modifier
                .size(50.dp)
                .border(1.dp, Color.White)
        )
        ContractHeaderTextBody(contractTitle, contractDate, contractSport)
    }
}

@Composable
private fun ContractHeaderTextBody(
    contractTitle: String,
    contractDate: String,
    contractSport: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = contractTitle,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.width(84.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "$contractDate | $contractSport",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ContractBodyContent(
    gradientBrush: Brush,
    contractLine: String,
    contractCost: Int,
    contractGain: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                brush = gradientBrush,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(7.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = contractLine,
            fontSize = 12.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )

        BlueDottedLine()

        CostGainTextBody(contractCost, contractGain)
    }
}

@Composable
private fun CostGainTextBody(contractCost: Int, contractGain: Int) {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = "Cost: $contractCost",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFF97066)
        )
        Text(
            text = "Gain: $contractGain",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF47CD89)
        )
    }
}

@Composable
private fun BlueDottedLine() {
    Canvas(
        modifier = Modifier.fillMaxWidth()
    ) {
        drawLine(
            color = Color(0xFF1F70C7),
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height),
            strokeWidth = 1.dp.toPx(),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f), 0f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContractCardPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContractCard(
            contractTitle = "C. Manon v. UPenn",
            contractDate = "03/24",
            contractSport = "Men's Basketball",
            contractLine = "4 Rebounds",
            contractCost = 1220,
            contractGain = 3240,
            playerImageUrl = "https://cornellbigred.com/images/2023/8/22/MBKB_Williams_Nazzir_23_CROP.jpg?width=80&quality=90"
        ){}
    }

}