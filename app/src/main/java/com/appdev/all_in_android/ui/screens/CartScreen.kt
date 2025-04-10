package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.appdev.all_in_android.ui.components.cart.CardHeader
import com.appdev.all_in_android.ui.components.cart.CartTotal
import com.appdev.all_in_android.ui.components.cart.GradientDivider
import com.appdev.all_in_android.ui.components.cart.HomeCartItem
import com.appdev.all_in_android.ui.components.cart.MarketplaceCartItem
import com.appdev.all_in_android.ui.theme.backgroundBlue

@Composable
fun CartScreen(
    wealth: Int,
    homeContracts: List<Contract>,
    marketplaceContracts: List<Contract>,
    //navBack: () -> Unit
    navController: NavController
) {
    var homeBetsTotal = 0
    var marketplaceBetsTotal = 0
    var winAmt = 0

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = backgroundBlue)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.SpaceBetween
    ) {
        CardHeader(wealth, navController)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Home", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Amount", color = Color.White)
                Icon(
                    painter = painterResource(R.drawable.ic_message_question_circle),
                    contentDescription = "question_icon"
                )
            }
        }
        GradientDivider()
        Box(
            modifier = Modifier.weight(1f)
        ){
            LazyColumn(
            ) {
                items(homeContracts) {contract ->
                    //TODO: unhardcode
                    HomeCartItem("Epic", contract.cost)
                }
            }

        }
        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Marketplace", color = Color.White)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Amount", color = Color.White)
                Icon(
                    painter = painterResource(R.drawable.ic_message_question_circle),
                    contentDescription = "question_icon",
                    tint = Color.Unspecified
                )
            }

        }
        GradientDivider()
        Box(
            Modifier.weight(1f)
        ) {
            //marketplace
            LazyColumn(

            ) {
                items(marketplaceContracts) { contract ->
                    MarketplaceCartItem(
                        contract.playerName,
                        contract.actionType,
                        contract.cost,
                        contract.gain
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
        }

        //TODO: replace 0 with contract potential wins
        CartTotal(homeBetsTotal, marketplaceBetsTotal, 0, navController)
    }
}

@Preview
@Composable
fun CartScreenPreview() {
//    CartScreen(1000, players, players.subList(2, 4), {} )
}