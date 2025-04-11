package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.appdev.all_in_android.ui.components.bet_tracker.BetTrackerInfoCard
import com.appdev.all_in_android.ui.components.bet_tracker.ContractCard
import com.appdev.all_in_android.ui.components.bet_tracker.HorizontalContractCard
import com.appdev.all_in_android.ui.components.profile.MonthBarGraphBox
import com.appdev.all_in_android.ui.components.profile.WeekBarGraphBox
import com.appdev.all_in_android.ui.theme.AllinandroidTheme
import com.appdev.all_in_android.util.toDollarString
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BetTrackerScreen(
    currentAmount: Double,
    totalProfit: Double,
    ranking: Int,
    contractsSold: Int,
    ageOfAccount: Duration,
    recommendedContracts: List<Contract>,
    activeBets: List<Contract>,
    pastBets: List<Contract>,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    var weeklyOrMonthly by remember { mutableIntStateOf(0) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Your Bet Tracker",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight(600)
            )
            Box(
                modifier = Modifier.clickable(onClick = {navController.navigate("Bet Tracker FAQ")})
            ){
                Image(
                    painter = painterResource(R.drawable.question_mark),
                    contentDescription = "question mark",
                )
            }
         
        }
        var selectedTabIndex by remember { mutableIntStateOf(1) }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val options = listOf("Weekly", "Monthly")
                    SingleChoiceSegmentedButtonRow {
                        options.forEachIndexed { index, label ->
                            SegmentedButton(
                                shape = SegmentedButtonDefaults.itemShape(
                                    index = index,
                                    count = options.size
                                ),
                                onClick = { weeklyOrMonthly = index },
                                selected = index == weeklyOrMonthly,
                                label = {
                                    Text(
                                        text = label, fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            )
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.currency),
                            contentDescription = "currency",
                        )
                        Text(
                            text = currentAmount.toString(),
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            item {
                if (weeklyOrMonthly == 0) {
                    // todo remove dummy data
                    WeekBarGraphBox(
                        gain = 20.0,
                        gainThisWeek = -5.0,
                        gainLastWeek = 50.0,
                        dailyGains = listOf(
                            3000.0,
                            -2500.0,
                            1250.0,
                            4950.0,
                            -4000.0,
                            2500.0,
                            2700.0
                        ),
                        modifier = Modifier.fillMaxWidth(),
                    )
                } else {
                    MonthBarGraphBox(
                        gain = 20.0,
                        gainThisMonth = -5.0,
                        gainLastMonth = 50.0,
                        weeklyGains = listOf(3000.0, -2500.0, 1250.0, 4950.0),
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BetTrackerInfoCard(
                            titleText = "Total Profit",
                            bodyText = toDollarString(totalProfit, toInt = true)
                        )
                        BetTrackerInfoCard(titleText = "Ranking No.", bodyText = ranking.toString())
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BetTrackerInfoCard(
                            titleText = "No. of Contracts Sold",
                            bodyText = contractsSold.toString()
                        )
                        BetTrackerInfoCard(
                            titleText = "Age of Account",
                            bodyText = ageOfAccount.toString()
                        )
                    }
                }
            }
            item {
                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "Recommended Marketplace Contracts",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Image(
                        painter = painterResource(R.drawable.baseline_chevron_right_24),
                        contentDescription = "right button",
                    )
                }
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(recommendedContracts) {
                        ContractCard(it, onClick = {})
                    }
                }
            }
            item {
                TabRow(selectedTabIndex, { selectedTabIndex = it })
            }
            val bets = if (selectedTabIndex == 0) activeBets else pastBets
            items(bets) {
                HorizontalContractCard(contract = it, onClick = {})
            }
        }
        // bottom navigation
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabRow(selectedTabIndex: Int, setSelectedTabIndex: (Int) -> Unit) {
    val tabs = listOf("Active Bets", "Past Bets")

    Column(horizontalAlignment = Alignment.Start) {
        PrimaryTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,

            ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { setSelectedTabIndex(index) },
                    text = { Text(text = title, color = Color.White) }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> {}//todo
            1 -> {}//todo
        }
    }
}

//@Preview
//@Composable
//private fun BetTrackerScreenPreview() {
//    AllinandroidTheme {
//        BetTrackerScreen(
//            modifier = Modifier, currentAmount = 1000.0,
//            totalProfit = 64.0,
//            ranking = 52,
//            contractsSold = 7,
//            ageOfAccount = 17.toDuration(DurationUnit.DAYS),
//            recommendedContracts = List(3) {
//                Contract(
//                    id = "0",
//                    playerName = "Chris Manon",
//                    playerImageId = R.drawable.player_photo,
//                    opposingTeam = "UPenn",
//                    dateOfGame = "03/24",
//                    actionType = "Rebounds",
//                    actionQuantity = 4,
//                    cost = 1220.0,
//                    gain = 3240.0,
//                    sport = "Men's Basketball"
//                )
//            },
//            activeBets = List(3) {
//                Contract(
//                    id = "0",
//                    playerName = "Chris Manon",
//                    playerImageId = R.drawable.player_photo,
//                    opposingTeam = "UPenn",
//                    dateOfGame = "03/24",
//                    actionType = "Rebounds",
//                    actionQuantity = 4,
//                    cost = 1220.0,
//                    gain = 3240.0,
//                    sport = "Men's Basketball"
//                )
//            },
//            pastBets = List(3) {
//                Contract(
//                    id = "0",
//                    playerName = "Chris Manon",
//                    playerImageId = R.drawable.player_photo,
//                    opposingTeam = "UPenn",
//                    dateOfGame = "03/24",
//                    actionType = "Rebounds",
//                    actionQuantity = 4,
//                    cost = 1220.0,
//                    gain = 3240.0,
//                    sport = "Men's Basketball"
//                )
//            }
//        )
//    }
//}

