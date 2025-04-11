package com.appdev.all_in_android.ui.components.marketplace

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.ui.theme.gradientBrush

@Composable
fun WideContractCard(
    contract: Contract,
    onClick: () -> Unit = {},
) {

    val (_, playerName, playerImageId, opponentTeam, date, actionQuantity, actionType, cost, gain, sport) = contract
    Box(
        modifier = Modifier
            .width(345.dp)
            .background(brush = gradientBrush, shape = RoundedCornerShape(12))
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = null
            )
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
                Column(modifier = Modifier.width(180.dp)) {
                    Text(text = "$playerName v. $opponentTeam", fontSize = 16.sp)
                    Text(text = "$date | $sport", fontSize = 12.sp, lineHeight = 12.sp)
                    Text(text = actionType, fontSize = 12.sp, lineHeight = 12.sp)
                }
            }

            Column {
                Text("Cost: $cost", color = Color(0xFFF97066), fontSize = 12.sp)
                Text("Gain: $gain", color = Color(0xFF47CD89), fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
private fun WideContractCardPreview() {
    WideContractCard(
        Contract(
            id = "0",
            playerName = "Jake Shane",
            playerImageId = R.drawable.player_photo,
            opposingTeam = "Harvard",
            dateOfGame = "3/24",
            actionQuantity = 1,
            actionType = "Scores first goal of game",
            gain = 20.0,
            cost = 40.0,
            sport = "Men's Ice Hockey",
        )
    )
}