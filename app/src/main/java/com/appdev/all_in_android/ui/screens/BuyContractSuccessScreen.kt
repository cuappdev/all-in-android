package com.appdev.all_in_android.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.appdev.all_in_android.R
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.ui.components.bet_tracker.ContractCard
import com.appdev.all_in_android.ui.components.general.BetCard

@Composable
fun BuyContractSuccessScreen(
    onReturnClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0C1E))
            .padding(24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(Modifier.height(24.dp))

            // Close button (top-right)
//            Box(modifier = Modifier.fillMaxWidth()) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_close),
//                    contentDescription = "Close",
//                    tint = Color.White,
//                    modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .size(24.dp)
//                )
//            }

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Congratulations! You have purchased a contract.",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))



            // Contract Card

            ContractCard(
                Contract(
                    id = "0",
                    playerName = "Chris Manon",
                    playerImageId = R.drawable.player_photo,
                    opposingTeam = "UPenn",
                    dateOfGame = "03/24",
                    actionType = "Rebounds",
                    actionQuantity = 4,
                    cost = 1220.0,
                    gain = 3240.0,
                    sport = "Men's Basketball"
                ), onClick = {}
            )

            Spacer(modifier = Modifier.height(48.dp))


            Spacer(modifier = Modifier.weight(1f))
            // Return Button
            Button(
                onClick = { onReturnClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E1E2F),
                )
            ) {
                Text(
                    text = "Return to Marketplace",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun BuyContractSuccessScreenPreview() {
//    BuyContractSuccessScreen()
//}