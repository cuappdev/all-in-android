package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.components.general.BetCard
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.ui.components.general.PlayerCard
import com.appdev.all_in_android.ui.components.general.RarityPack
import com.appdev.all_in_android.ui.navigation.NavUnit
import com.appdev.all_in_android.ui.theme.gradientBorder
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.rememberCoroutineScope
import com.appdev.all_in_android.ui.components.general.RarityIcon
import kotlinx.coroutines.launch


data class ActiveBet(
    val title: String,
    val date: String,
    val sport: String,
    val bettingLine: String,
    val cost: Double,
    val gain: Double,
    val playerImageUrl: String = "",
)

data class PlayerCardInfo(
    val playerName: String,
    val playerNumber: Int,
    val playerPosition: String,
    val playerImageUrl: String = "",
    val onClick: () -> Unit

)

data class RankingInfo(
    val name: String,
    val money: Int,
    val ranking: Int,
    val change: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    //toCart: () -> Unit
) {
    //TODO: replace with viewmodel call
    val playerMoney = 1000
    val activeBets = listOf(
        ActiveBet(
            title = "Jake Shane v. Harvard",
            date = "03/24",
            sport = "Men's Hockey",
            bettingLine = "Scores first goal of game",
            cost = 20.00,
            gain = 40.00,
        ),
        ActiveBet(
            title = "Jake Shane v. Harvard",
            date = "03/24",
            sport = "Men's Hockey",
            bettingLine = "Scores first goal of game",
            cost = 20.00,
            gain = 40.00
        ),
        ActiveBet(
            title = "Jake Shane v. Harvard",
            date = "03/24",
            sport = "Men's Hockey",
            bettingLine = "Scores first goal of game",
            cost = 20.00,
            gain = 40.00
        )
    )
    val sportsList = listOf(
        Pair("Basketball", R.drawable.ic_basketball),
        Pair("Hockey", R.drawable.ic_basketball),
        Pair("Lacrosse", R.drawable.ic_basketball),
        Pair("Football", R.drawable.ic_basketball)
    )

    // Add these state variables for the bottom sheet
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedRarity by remember { mutableStateOf("") }
    val bottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    // Update rarity pack onClick handlers
    val rarityPackList = listOf(
        Pair("Common") {
            selectedRarity = "Common"
            showBottomSheet = true
        },
        Pair("Rare") {
            selectedRarity = "Rare"
            showBottomSheet = true
        },
        Pair("Epic") {
            selectedRarity = "Epic"
            showBottomSheet = true
        },
        Pair("Legendary") {
            selectedRarity = "Legendary"
            showBottomSheet = true
        }
    )
    val playerCardlist = listOf(
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        )
    )
    val rankingInfoList = listOf(
        RankingInfo(
            name = "andrewcheung",
            money = 5000,
            ranking = 4,
            change = 4
        ),
        RankingInfo(
            name = "amywang",
            money = 4000,
            ranking = 5,
            change = 3
        ),
        RankingInfo(
            name = "emiljiang",
            money = 3000,
            ranking = 6,
            change = 1
        ),
        RankingInfo(
            name = "calebshim",
            money = 2000,
            ranking = 7,
            change = 2
        ),
        RankingInfo(
            name = "jiwonjeong",
            money = 1000,
            ranking = 8,
            change = 3
        ),

    )

    // Display bottom sheet when needed
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = bottomSheetState,
            containerColor = Color(0xFF15141B)
        ) {
            RarityPackBottomSheet(
                rarity = selectedRarity,
                onBuy = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                        showBottomSheet = false
                    }
                },
                onDismiss = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                        showBottomSheet = false
                    }
                }
            )
        }
    }
    Scaffold(
        topBar = {
            HomeTopBar(onClickFaq = {navController.navigate("Home FAQ")})
        },
        containerColor = Color(0xFF15141B),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("Cart")},
                containerColor = Color(0xff1F70C7), // Customize background color
                contentColor = Color.White, // Icon tint
                shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_cart_button),
                    contentDescription = "FAB",
                    tint = Color.Unspecified
                )
            }
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                )
                .verticalScroll(rememberScrollState())
        ){
            UserMoneyDisplay(playerMoney)
            HeaderButton(title = "My Active Bets")
            ActiveBetsRow(activeBets)
            SportsRow(sportsList)
            Text(
                text = "Rarity",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            RarityPacksGrid(rarityPackList)
            HeaderButton(title = "Players", onClick = {navController.navigate("Player See All")})
            PlayerCardRow(playerCardlist)
            HeaderButton(title = "Your Ranking", onClick = {
                navController.navigate("Ranking")
            })
            RankingList(rankingInfoList)
        }
    }
}

@Composable
fun RarityPackBottomSheet(
    rarity: String,
    onBuy: () -> Unit,
    onDismiss: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$rarity Pack",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            IconButton(
                onClick = onDismiss,
                modifier = Modifier
                    .size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_white_x_close),
                    contentDescription = "Close",
                    tint = Color.Unspecified
                )
            }
        }

        RarityIcon(rarity)

        // Price
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dollar_circle),
                contentDescription = "Price",
                tint = Color.Unspecified
            )
            Text(
                text = "${getPackPrice(rarity)}",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        // Pack description
        Text(
            text = getPackDescription(rarity),
            color = Color(0xFF979797),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

        val gradientBrush = Brush.linearGradient(
            colors = listOf(
                Color(0xFF1F70C7),
                Color(0xFF7DF3FE),
                Color(0xFF887DFE),
                Color(0xFF7D97FE)
            )
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(
                    brush = gradientBrush,
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable(
                    onClick = onBuy,
                    indication = null,
                    interactionSource = null
                ),
        ) {
            Text("Buy Now", color = Color(0xFF15141B), fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}

// Helper functions for pack information
private fun getPackDescription(rarity: String): String {
    return when(rarity) {
        "Common" -> "Contains a Common contract"
        "Rare" -> "Contains a Rare contract"
        "Epic" -> "Contains an Epic contract"
        "Legendary" -> "Contains a Legendary contract"
        else -> "Pack contains random player cards."
    }
}

private fun getPackPrice(rarity: String): Int {
    return when(rarity) {
        "Common" -> 100
        "Rare" -> 250
        "Epic" -> 500
        "Legendary" -> 1000
        else -> 0
    }
}

@Composable
fun RankingList(rankingInfoList: List<RankingInfo>, padding: Int = 24) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = padding.dp
            )
            .gradientBorder()
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 18.dp,
                    horizontal = 16.dp
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            rankingInfoList.forEach { rankingInfo ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .gradientBorder()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "@${rankingInfo.name}",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_up_arrow),
                                    contentDescription = "up arrow",
                                    tint = Color.Unspecified,

                                    )
                                Text(
                                    text = "${rankingInfo.change}",
                                    color = Color(0xFF47CD89),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_dollar_circle),
                                contentDescription = "Money",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(12.dp)
                            )
                            Text(
                                text = "${rankingInfo.money}",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )

                        }
                    }
                    Text(
                        text = "#${rankingInfo.ranking}",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )

                }

            }
        }


    }
}

@Composable
private fun PlayerCardRow(playerCardlist: List<PlayerCardInfo>) {
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 24.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(playerCardlist) { playerCard ->
            PlayerCard(
                playerName = playerCard.playerName,
                playerNumber = playerCard.playerNumber,
                playerPosition = playerCard.playerPosition,
                onClick = playerCard.onClick
            )
        }
    }
}

@Composable
private fun RarityPacksGrid(rarityPackList: List<Pair<String, () -> Unit>>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(17.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(400.dp)
            .padding(horizontal = 24.dp)
    ) {
        items(rarityPackList) { rarityPack ->
            RarityPack(
                rarityPack.first,
                rarityPack.second
            )
        }
    }
}

@Composable
private fun SportsRow(sportsList: List<Pair<String, Int>>) {
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 24.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(sportsList) { sport ->
            val gradientBrush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF1F70C7),
                    Color(0xFF7DF3FE),
                    Color(0xFF887DFE),
                    Color(0xFF7D97FE)
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        brush = gradientBrush,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        vertical = 4.dp,
                        horizontal = 12.dp
                    )
            ) {
                Icon(
                    painter = painterResource(sport.second),
                    contentDescription = sport.first,
                    tint = Color.Unspecified
                )
                Text(
                    text = sport.first,
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
private fun ActiveBetsRow(activeBets: List<ActiveBet>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(
            horizontal = 24.dp
        ),
    ) {
        items(activeBets) { bet ->
            BetCard(
                title = bet.title,
                date = bet.date,
                sport = bet.sport,
                bettingLine = bet.bettingLine,
                cost = bet.cost,
                gain = bet.gain,
                playerImageUrl = bet.playerImageUrl
            )
        }
    }
}

@Composable
private fun HeaderButton(
    title: String,
    onClick: () -> Unit = {}
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clickable(
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            8.dp,
            Alignment.Start
        )
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_chevron_right),
            contentDescription = "Chevron",
            tint = Color.Unspecified,
            modifier = Modifier
                .width(8.dp)
                .height(16.dp)
        )
    }
}

@Composable
private fun UserMoneyDisplay(playerMoney: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            7.dp,
            Alignment.End
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_dollar_circle),
            contentDescription = "Money",
            tint = Color.Unspecified,
        )
        Text(
            text = "$$playerMoney",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun HomeTopBar(
    onClickFaq: () -> Unit = {},
    //navController: NavController
) {
    TopAppBar(
        title = {
            Text(
                text = "All In",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF15141B),
        ),
        actions = {
            IconButton(onClick = {onClickFaq()}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_question_circle),
                    contentDescription = "FAQ",
                    tint = Color.Unspecified
                )
            }
        },
        modifier = Modifier.padding(horizontal = 10.dp)
    )
}


//@Preview(showBackground = true)
//@Composable
//private fun HomeScreenPreview() {
//    HomeScreen({})
//}