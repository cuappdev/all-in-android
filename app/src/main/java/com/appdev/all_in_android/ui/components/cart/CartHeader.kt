package com.appdev.all_in_android.ui.components.cart

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
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.theme.backgroundBlue
import com.appdev.all_in_android.ui.theme.gradientBrush

@Composable
fun CardHeader(
    wealth: Int,
    navBack: () -> Unit
) {
    val cartTotal = 100
    val winAmt = 1540

    Column(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(top = 40.dp, start = 20.dp, end = 20.dp, bottom = 40.dp)
            .background(color = backgroundBlue)
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
                color = Color.White
            )
            Box(
                modifier = Modifier.clickable(onClick = { navBack() })
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_white_x_close),
                    contentDescription = "x-close",
                    tint = Color.Unspecified
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(end = 5.dp),
                painter = painterResource(R.drawable.ic_currency_dollar_circle),
                contentDescription = "currency-icon",
                tint = Color.Unspecified
            )
            Text("$${wealth}", fontSize = 20.sp, color = Color.White) //TODO - un-hardcode this
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun CartTotal(
    homeBetsTotal: Int,
    marketplaceBetsTotal: Int,
    potentialWinnings: Int,
    navBack: () -> Unit
) {
    Column(
        modifier = Modifier
            //.padding(horizontal = 24.dp)
            .fillMaxWidth()
    ) {
        GradientDivider()
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Totals",
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))

        CartRowItem(
            "Home bets total",
            homeBetsTotal,
            ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        CartRowItem(
            "Marketplace bets total",
            marketplaceBetsTotal,
            "Win Win 3 x \$450 = $${potentialWinnings} if all true"
        )
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            //.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .background(
                        brush = gradientBrush,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .fillMaxWidth(),
                onClick = {navBack()},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text("Confirm to spend $${homeBetsTotal + marketplaceBetsTotal}")
            }
        }

    }
}


@Preview
@Composable
fun PreviewCardHeader() {
    Column(
        modifier = Modifier.background(color = backgroundBlue)
    ) {
        CardHeader(1000, {})
        //CartTotal(80, 190, 160)
    }
}
