package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.components.general.BetCard
import com.appdev.all_in_android.ui.theme.backgroundBlue

@Composable
fun SellContractScreen(

) {
    Column(modifier = Modifier
        .background(color = backgroundBlue)
        .padding(24.dp)
        .fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .size(24.dp)
                .clickable {  }
        )
        Spacer(Modifier.height(40.dp))
        Text(
            text = "Sell a Contract",
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 48.sp,
                letterSpacing = (-0.72).sp
            )
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Select one of your active bets and put it on the marketplace at your desired price!",
            style = TextStyle(
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 16.sp,
                letterSpacing = (-0.45).sp
            )
        )
        Spacer(Modifier.height(20.dp))
        LazyColumn {
            items(3) {
                BetCard(
                    title = "Jake Shane v. Harvard", date = "3/24", sport = "Men's Ice Hockey", bettingLine = "Scores First Goal of Game",
                    cost = 20.0, gain = 40.0, onClick = { /*TODO*/ },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SellContractScreenPreview() {
    SellContractScreen()
}