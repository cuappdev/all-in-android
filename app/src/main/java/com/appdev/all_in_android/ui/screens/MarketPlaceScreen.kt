package com.appdev.all_in_android.ui.screens

import android.view.RoundedCorner
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
import androidx.compose.material3.SearchBar
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
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.components.general.AllInTopBar
import com.appdev.all_in_android.ui.components.general.PlayerCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketPlaceScreen() {
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
                    items(count = 5){
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                        ){
                            PlayerCard(R.drawable.player_photo, "Player Name", "04/26", 4, "FGA", 1000, 2000)
                            Spacer(Modifier.padding(2.dp))
                            PlayerCard(R.drawable.player_photo, "Player Name", "04/26", 4, "FGA", 1000, 2000)
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
        modifier = Modifier.fillMaxWidth()
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
fun FilterRow(){
    LazyRow{
        items(count = 10){
            FilterButton()
        }
    }
}

@Composable
fun FilterButton(){
    Button(
        onClick = {},
        colors = ButtonColors(containerColor = Color.LightGray,
            contentColor = Color.DarkGray,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.DarkGray),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.padding(2.dp)
    ){
        Text("pts")
    }
}

@Preview
@Composable
fun MarketPlacePreview() {
    MarketPlaceScreen()
}