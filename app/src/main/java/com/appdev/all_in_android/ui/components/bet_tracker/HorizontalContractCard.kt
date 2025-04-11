package com.appdev.all_in_android.ui.components.bet_tracker

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.appdev.all_in_android.R
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.ui.theme.AllinandroidTheme
import com.appdev.all_in_android.ui.theme.CostRed
import com.appdev.all_in_android.ui.theme.GainGreen
import com.appdev.all_in_android.ui.theme.gradientBorder

@Composable
fun HorizontalContractCard(contract: Contract, onClick: () -> Unit) {
    val (_, playerName, playerImageUrl, opposingTeam, contractDate, actionQuantity, actionType, contractCost, contractGain, contractSport) = contract
    val contractTitle = "$playerName v. $opposingTeam"
    val contractLine = "$actionQuantity ${actionType.capitalize(Locale.current)}"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .gradientBorder()
            .padding(16.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            AsyncImage(
                model = playerImageUrl,
                contentDescription = "player image",
                modifier = Modifier
                    .size(50.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = contractTitle,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "$contractDate | $contractSport",
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = contractLine,
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Column(
            Modifier.padding(start=16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
        ) {
            Text(
                text = "Cost: $contractCost",
                fontSize = 12.sp,
                lineHeight = 12.sp,
                color = CostRed,
                fontWeight = FontWeight.Light,
            )
            Text(
                text = "Gain: $contractGain",
                fontSize = 12.sp,
                lineHeight = 12.sp,
                color = GainGreen,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Preview
@Composable
private fun HorizontalContractCardPreview() {
    AllinandroidTheme {
        HorizontalContractCard(
            Contract(
                id = "0",
                playerName = "Chris Manon",
                playerImageId = R.drawable.player_photo,
                opposingTeam = "UPenn",
                dateOfGame = "03/24",
                actionType = "Rebounds",
                actionQuantity = 4,
                cost = 20.0,
                gain = 40.0,
                sport = "Men's Basketball"
            ), onClick = {}
        )
    }
}