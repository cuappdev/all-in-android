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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.components.general.BetCard

@Composable
fun ContractSuccessScreen(
    onReturnClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0C1E)) // dark background
            .padding(24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
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
                text = "Amazing! Your contract is on the marketplace.",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))



            // Contract Card

            BetCard(
                title = "Jake Shane v. Harvard", date = "3/24", sport = "Men's Ice Hockey", bettingLine = "Scores First Goal of Game",
                cost = 20.0, gain = 40.0, onClick = { /*TODO*/ },
            )

            Spacer(modifier = Modifier.height(48.dp))


            Spacer(modifier = Modifier.weight(1f))
            // Return Button
            Button(
                onClick = onReturnClick,
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

@Preview(showBackground = true)
@Composable
private fun ContractSuccessScreenPreview() {
    ContractSuccessScreen()
}