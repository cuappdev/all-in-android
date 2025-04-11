package com.appdev.all_in_android.ui.components.marketplace

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.theme.gradientBrush

@Composable
fun WideContractCard(
    playerName: String,
    opponentTeam: String,
    date: String,
    sport: String,
    actionType: String,
    cost: Int,
    gain: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = gradientBrush, shape = RoundedCornerShape(12))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //TODO: unhardcode
            Row {
                Image(
                    modifier = Modifier
                        .width(37.dp)
                        .height(47.dp),
                    painter = painterResource(R.drawable.player_photo),
                    contentDescription = "TEMP PHOTO"
                )
                Spacer(Modifier.width(16.dp))
                //TODO: how to get "v. Harvard" from the contract data?
                Column {
                    Text(text = "${playerName} v. $opponentTeam", fontSize = 16.sp)
                    Text(text = "$date | $sport", fontSize = 12.sp)
                    Text(text = actionType, fontSize = 12.sp)
                }
            }

            Column {
                Text("Cost: $cost", color = Color(0xFFF97066), fontSize = 12.sp)
                Text("Gain: ${gain}", color = Color(0xFF47CD89), fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
private fun WideContractCardPreview() {
    WideContractCard(
        "Jake Shane",
        "Harvard",
        "3/24",
        "Men's Ice Hockey",
        "Scores first goal of game",
        20,
        40
    )
}