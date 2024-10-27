package com.appdev.all_in_android.ui.components.general

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R

/**
 * Component card representing a contract
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerCard(
    // TODO - discuss best way to pass in image - maybe image id?
    playerImageId: Int,
    playerName: String,
    //TODO - discuss how to represent the date & action type stuff
    dateOfGame: String,
    actionQuantity: Int,
    actionType: String,
    cost: Int,
    gain: Int
    ) {

    OutlinedCard (modifier = Modifier.width(181.dp).height(222.dp), border = BorderStroke(width = 1.dp, color = Color(0xFF606060)))
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(17.dp)) {
            Image(painter = painterResource(playerImageId), contentDescription = "player image", modifier = Modifier.size(83.dp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(playerName, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF606060))
            Text("VS $dateOfGame", fontSize = 12.sp, color = Color(0xFF606060))

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(55.dp)
                    .background(color = Color(0x69DED9D9), shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 9.dp, vertical = 13.dp),
                ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(60.dp).height(30.dp)) {
                    // 4 FGA bit
                    Text("$actionQuantity" , fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(actionType, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }

                VerticalDivider(color = Color(0xFFFF4F4F), modifier = Modifier.padding(horizontal = 7.dp), thickness = 1.dp)

                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(53.dp).height(30.dp), verticalArrangement = Arrangement.Center) {
                    // cost gain part
                    Text("Cost: $cost", fontSize = 10.sp)
                    Text("Gain: $gain", fontSize = 10.sp)
                }
            }

        }
    }

}

@Preview @Composable
fun PlayerCardPreview() {
    PlayerCard(R.drawable.player_photo, "Player Name", "04/26", 4, "FGA", 1000, 2000)
}

