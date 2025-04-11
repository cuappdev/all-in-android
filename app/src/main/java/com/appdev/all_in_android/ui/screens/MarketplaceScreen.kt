package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.ui.components.bet_tracker.ContractCard
import com.appdev.all_in_android.ui.components.marketplace.WideContractCard
import com.appdev.all_in_android.ui.theme.AllinandroidTheme
import com.appdev.all_in_android.ui.theme.fontFamily
import com.appdev.all_in_android.ui.theme.gradientBrush
import com.appdev.all_in_android.util.myFavoriteContract
import com.appdev.all_in_android.util.toCurrency

@Composable
fun MarketplaceScreen(
    modifier: Modifier = Modifier,
    currentAmount: Double,
    recommendedContracts: List<Contract>,
    contractsEndingToday: List<Contract>,
    allContracts: List<Contract>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Header()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(span = { GridItemSpan(2) }) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.currency),
                            contentDescription = "currency",
                        )
                        Text(
                            text = toCurrency(currentAmount),
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            item(span = { GridItemSpan(2) }) {
                var query by remember { mutableStateOf("") }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchBar(
                        query = query,
                        onQueryChanged = { query = it },
                    )
                    Icon(
                        painter = painterResource(R.drawable.filter),
                        contentDescription = "Filter Icon",
                        tint = Color.White
                    )
                }
            }
            item(span = { GridItemSpan(2) }) {
                Text(
                    text = "Your Recommended Contracts",
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
            item(span = { GridItemSpan(2) }) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(recommendedContracts) {
                        ContractCard(it, onClick = {})
                    }
                }
            }
            item(span = { GridItemSpan(1) }) {
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(
                        text = "Contracts Ending Today",
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.Medium,
                        style = TextStyle(
                            brush = gradientBrush,
                            fontFamily = fontFamily
                        )
                    )
                    Icon(
                        painter = painterResource(R.drawable.baseline_chevron_right_24),
                        contentDescription = "chevron",
                        modifier = Modifier.drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradientBrush, blendMode = BlendMode.SrcAtop)
                            }
                        }
                    )
                }
            }
            item(span = { GridItemSpan(2) }) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(contractsEndingToday) {
                        WideContractCard(it)
                    }
                }
            }
            item(span = { GridItemSpan(2) }) {
                Text(
                    text = "All Contracts",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                )
            }
            items(allContracts) {
                ContractCard(it, onClick = {})
            }
        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    placeholder: String = "Search"
) {
    Box(
        modifier = Modifier
            .width(309.dp)
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChanged,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(40.dp)),
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_search_24),
                    contentDescription = "Search Icon",
                    tint = Color.Black
                )
            },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = { onQueryChanged("") }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear",

                            )
                    }
                }
            }

        )
    }
}


@Composable
private fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Marketplace",
                fontSize = 24.sp,
                color = Color.White,
                lineHeight = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
            Image(
                painter = painterResource(R.drawable.question_mark),
                contentDescription = "question mark"
            )
        }
    }
}

@Preview
@Composable
fun MarketplaceScreenPreview() {
    AllinandroidTheme {
        MarketplaceScreen(
            currentAmount = 1000.0,
            recommendedContracts = List(3) {
                myFavoriteContract
            },
            contractsEndingToday = List(3) {
                myFavoriteContract
            },
            allContracts = List(10) { myFavoriteContract }


        )
    }
}