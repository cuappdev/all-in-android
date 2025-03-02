package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.appdev.all_in_android.R
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.ui.components.general.AllInTopBar
import com.appdev.all_in_android.ui.components.general.PlayerCard
import com.appdev.all_in_android.viewmodel.HomeViewModel

data class PlayerChest(
    val id: Int,
    val name: String,
    val price: Int,
    val image: Int
)

data class RarityChest(
    val id: Int,
    val name: String,
    val price: Int,
    val rarity: String,
)

@Composable
fun HomeScreen(
    PlayerChests: List<PlayerChest> = emptyList(),
    RarityChests: List<RarityChest> = emptyList(),
    MarketContracts: List<Contract> = emptyList(),
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiStateFlow.collectAsState()

    Scaffold(
        topBar = { AllInTopBar(title = "All In", money = 1000) },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F7))
                .padding(
                    top = innerPadding.calculateTopPadding() + 16.dp,
                    start = 24.dp,
//                    end = 24.dp
                )
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            // Popular Now Section
            SectionRow(
                title = "Popular Now",
                Cards = PlayerChests,
            )
            // All Chests
            SectionRow(
                title = "All Chests",
                Cards = uiState.playerList//RarityChests,
            )
            // Marketplace
            SectionRow(
                title = "Marketplace",
                Cards = MarketContracts,
                height = 300)
        }
    }
}

@Composable
private fun <T> SectionRow(
    title: String,
    Cards: List<T> = emptyList(),
    height: Int = 250
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                end = 16.dp
            )
        ){
            items(Cards) { card ->
                when(card){
//                    is PlayerChest -> {
//                        PlayerChestCard(
//                            id = card.id,
//                            name = card.name,
//                            price = card.price,
//                            image = card.image
//                        )
//                    }
//                    is RarityChest -> {
//                        RarityChestCard(
//                            id = card.id,
//                            name = card.name,
//                            price = card.price,
//                            rarity = card.rarity
//                        )
//                    }
                    is Contract -> {
                        PlayerCard(
                            playerImageId = card.playerImageId,
                            playerName = card.playerName,
                            dateOfGame = card.dateOfGame,
                            actionQuantity = card.actionQuantity,
                            actionType = card.actionType,
                            cost = card.cost,
                            gain = card.gain
                        )
                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val contracts = listOf<Contract>(
        Contract(
            "1",
            "John Doe",
            R.drawable.player_photo,
            "VS 04/26",
            4,
            "FGA",
            1000,
            2000
        ),
        Contract(
            "2",
            "Jane Doe",
            R.drawable.player_photo,
            "VS 04/26",
            4,
            "FGA",
            1000,
            2000
        ),
        Contract(
            "3",
            "John Doe",
            R.drawable.player_photo,
            "VS 04/26",
            4,
            "FGA",
            1000,
            2000
        ),
        Contract(
            "4",
            "Jane Doe",
            R.drawable.player_photo,
            "VS 04/26",
            4,
            "FGA",
            1000,
            2000
        ),
        Contract(
            "5",
            "John Doe",
            R.drawable.player_photo,
            "VS 04/26",
            4,
            "FGA",
            1000,
            2000
        ),
        Contract(
            "6",
            "Jane Doe",
            R.drawable.player_photo,
            "VS 04/26",
            4,
            "FGA",
            1000,
            2000
        ),

        )
    HomeScreen(
        MarketContracts = contracts
    )
}