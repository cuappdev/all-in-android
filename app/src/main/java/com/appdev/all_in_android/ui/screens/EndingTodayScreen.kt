package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.appdev.all_in_android.R
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.data.models.ContractRepo.players
import com.appdev.all_in_android.ui.components.marketplace.WideContractCard
import com.appdev.all_in_android.ui.theme.backgroundBlue
import com.appdev.all_in_android.ui.theme.fontFamily

@Composable
fun EndingTodayScreen(
    contracts: List<Contract>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .background(color = backgroundBlue)
            .padding(horizontal = 24.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(44.dp))

        Box(
            modifier = Modifier.clickable(onClick = {navController.popBackStack()})
        ) {
            Image(
                painter = painterResource(R.drawable.ic_back_arrow),
                contentDescription = "back arrow"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Contracts Ending Today",
            fontFamily = fontFamily,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(contracts) { contract ->
                WideContractCard(
                    contract
                )
            }
        }

    }
}

//@Preview
//@Composable
//private fun EndingTodayPreview() {
//    EndingTodayScreen(players)
//}