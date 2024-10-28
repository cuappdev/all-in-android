package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appdev.all_in_android.models.Contract
import com.appdev.all_in_android.models.ContractRepo
import com.appdev.all_in_android.ui.components.general.AllInTopBar
import com.appdev.all_in_android.ui.components.general.PlayerCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketplaceScreen(contracts : List<Contract>) {
    Scaffold(
        topBar = { AllInTopBar("Marketplace", 1000) }
    ) { padding ->
        var searchQuery by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .padding(padding)
                .background(color = Color(0xffE6E6E6))
        ){
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()

            ){
                SearchBar(
                    searchQuery,
                    { searchQuery = it }
                )
                FilterRow()

                LazyColumn{
                    //contractsPaired is the contracts into rows of two contracts
                    val contractsPaired = contracts.chunked(2)
                    items(contractsPaired.size){rowItems ->
                        //rowItems represents index of each row, it and it2 index the first and second item in each row
                        val it = 2 * rowItems
                        val it2 = it + 1
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                        ){
                            PlayerCard(contracts[it].playerImageId,
                                contracts[it].playerName,
                                contracts[it].dateOfGame,
                                contracts[it].actionQuantity,
                                contracts[it].actionType,
                                contracts[it].cost,
                                contracts[it].gain
                            )
                            Spacer(Modifier.padding(2.dp))
                            // if-statement handles case in which the last row isn't full
                            if (it2 < contracts.size) {
                                PlayerCard(
                                    contracts[it2].playerImageId,
                                    contracts[it2].playerName,
                                    contracts[it2].dateOfGame,
                                    contracts[it2].actionQuantity,
                                    contracts[it2].actionType,
                                    contracts[it2].cost,
                                    contracts[it2].gain
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit
){
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
        placeholder = { Text("Search...") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search icon"
            )
        },
        singleLine = true
    )
}

@Composable
fun FilterButton(
    label: String,
    onFilterClicked: () -> Unit
){
    Button(
        onClick = onFilterClicked,
        colors = ButtonColors(containerColor = Color(0xfff6f6f6),
            contentColor = Color.DarkGray,
            disabledContainerColor = Color(0xffd6d6d6),
            disabledContentColor = Color.DarkGray),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.padding(2.dp)
    ){
        Text(label)
    }
}

@Composable
fun FilterRow(){
    LazyRow{
        item{
            FilterButton("pts", {})
        }
        item{
            FilterButton("min", {})
        }
        item{
            FilterButton("fg", {})
        }
        item{
            FilterButton("3pt", {})
        }
        item{
            FilterButton("ft", {})
        }
        item{
            FilterButton("reb", {})
        }
        item{
            FilterButton("ast", {})
        }
        item{
            FilterButton("stl", {})
        }
    }
}

@Preview
@Composable
fun MarketplacePreview() {
    MarketplaceScreen(ContractRepo.players)
}