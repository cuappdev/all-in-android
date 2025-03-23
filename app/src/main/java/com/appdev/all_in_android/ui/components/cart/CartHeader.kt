package com.appdev.all_in_android.ui.components.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
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
import com.appdev.all_in_android.ui.theme.DefaultGray

@Composable
fun CardHeader() {
    val cartTotal = 100
    val winAmt = 1540

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 20.dp, end = 20.dp, bottom = 40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Cart",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff444444)
            )
            Icon(
                painter = painterResource(R.drawable.ic_x_close),
                contentDescription = "x-close"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                modifier = Modifier.padding(end = 5.dp),
                painter = painterResource(R.drawable.ic_currency_dollar_circle),
                contentDescription = "currency-icon"
            )
            Text("$${cartTotal}") //TODO - un-hardcode this
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Game")
            ParlayQuestion()
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
    }
}

@Composable
fun CartTotal(
    contractBetsTotal: Int,
    contractBetsWinnings: Int,
    packBetsTotal: Int,
    packBetsWinnings: Int
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Totals",
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(20.dp))

        CartRowItem(
            "Contract bets total",
            contractBetsTotal,
            "Win ${contractBetsWinnings} if all true"
        )
        Spacer(modifier = Modifier.height(20.dp))
        CartRowItem(
            "Pack bets total",
            packBetsTotal,
            "Win Win 3 x \$450 = $${packBetsWinnings} if all true"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = DefaultGray),//androidx.compose.material3.ButtonDefaults(containerColor = DefaultGray),
                onClick = {}
            ) {
                Text("Confirm spend $${contractBetsTotal + packBetsTotal} to win $${contractBetsWinnings + packBetsWinnings}")
            }
        }

    }
}

@Preview
@Composable
fun ParlayQuestion() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Parlay")
        Icon(
            painter = painterResource(R.drawable.ic_question_circle),
            contentDescription = "question_icon"
        )
    }
}

@Preview
@Composable
fun PreviewCardHeader() {
    Column(
        modifier = Modifier.background(color = Color.White)
    ) {
        CardHeader()
        CartTotal(80, 190, 160, 1350)
    }
}
