package com.appdev.all_in_android.ui.screens

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
    val rarityPackList = listOf(
        Pair("Common", {}),
        Pair("Rare", {}),
        Pair("Epic", {}),
        Pair("Legendary", {})
    )
    val playerCardlist = listOf(
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {}
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {}
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {}
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {}
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {}
        )
    )
    val rankingInfoList = listOf(
        RankingInfo(
            name = "andrewcheung",
            money = 9000,
            ranking = 1,
            change = 4
        ),
        RankingInfo(
            name = "amywang",
            money = 8000,
            ranking = 2,
            change = 3
        ),
        RankingInfo(
            name = "emiljiang",
            money = 7000,
            ranking = 3,
            change = 1
        ),
        RankingInfo(
            name = "calebshim",
            money = 6000,
            ranking = 4,
            change = 2
        ),
        RankingInfo(
            name = "laurenjun",
            money = 5000,
            ranking = 5,
            change = 3
        ),

    )
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
            HeaderButton(title = "Players")
            PlayerCardRow(playerCardlist)
            HeaderButton(title = "Your Ranking")
            RankingList(rankingInfoList)
        }
    }
}

@Composable
fun RankingList(rankingInfoList: List<RankingInfo>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp
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
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(17.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
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