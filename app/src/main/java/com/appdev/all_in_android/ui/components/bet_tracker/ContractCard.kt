package com.appdev.all_in_android.ui.components.bet_tracker

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.appdev.all_in_android.R
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.ui.theme.AllinandroidTheme
import com.appdev.all_in_android.ui.theme.fontFamily
import com.appdev.all_in_android.ui.theme.gradientBorder
import com.appdev.all_in_android.ui.theme.gradientBrush
import com.appdev.all_in_android.util.firstInitialLastName
import java.util.Locale

@Composable
fun ContractCard(
    contract: Contract,
    onClick: () -> Unit
) {
    val (_, playerName, playerImageUrl, opposingTeam, contractDate, actionQuantity, actionType, contractCost, contractGain, contractSport) = contract
    val contractTitle = "${firstInitialLastName(playerName)} v. $opposingTeam"
    val contractLine = "$actionQuantity ${actionType.uppercase(Locale.US)}"
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .width(160.dp)
            .height(190.dp)
            .gradientBorder()
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
    playerImageUrl: Int,
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
            fontWeight = FontWeight.Normal,
            modifier = Modifier.width(84.dp),
            textAlign = TextAlign.Center,
            lineHeight = 16.sp
        )
        Text(
            text = "$contractDate | $contractSport",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontFamily = fontFamily,
            letterSpacing = 0.sp,
            lineHeight = 12.sp
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
            fontWeight = FontWeight.Medium,
            lineHeight = 12.sp
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
            color = Color(0xFFF97066),
            lineHeight = 12.sp
        )
        Text(
            text = "Gain: $contractGain",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF47CD89),
            lineHeight = 12.sp
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
    AllinandroidTheme {
        ContractCard(
            Contract(
                id = "0",
                playerName = "Chris Manon",
                playerImageId = R.drawable.player_photo,
                opposingTeam = "UPenn",
                dateOfGame = "03/24",
                actionType = "Rebounds",
                actionQuantity = 4,
                cost = 1220,
                gain = 3240,
                sport = "Men's Basketball"
            ), onClick = {}
        )
    }

}

