package com.appdev.all_in_android.ui.components.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appdev.all_in_android.ui.theme.backgroundBlue

@Composable
fun HomeCartItem(
    rarity: String,
    cost: Double
) {
    var isChecked by remember { mutableStateOf(false) }

    Column(Modifier.background(color = backgroundBlue)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {

                Row {
                    Box(
                        modifier = Modifier.padding(end = 6.dp)
                    ) {
                        Checkbox(
                            isChecked = isChecked,
                            onClick = { isChecked = !isChecked })
                    }

                    Column {
                        Text(rarity, color = Color.White)
                        Text("Rarity Pack", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }


                Spacer(modifier = Modifier.width(8.dp))
                Text("$$cost", color = Color.White)
            }
        }
    }
}

@Composable
fun MarketplaceCartItem(
    name: String,
    type: String,
    cost: Double,
    winnings: Double
) {
    var isChecked by remember { mutableStateOf(false) }

    Column(Modifier.background(color = backgroundBlue)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Box(
                        modifier = Modifier.padding(end = 6.dp)
                    ) {
                        Checkbox(
                            isChecked = isChecked,
                            onClick = { isChecked = !isChecked })
                    }

                    Text("$name | $type", color = Color.White)

                }

                Column {
                    Text("$$cost", color = Color.White)
                    Text(
                        "Win $winnings if true",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun HomeCartItemPreview() {
    HomeCartItem("Epic", 400.0)
}

@Preview
@Composable
private fun MarketplaceCartItemPreview() {
    MarketplaceCartItem("C. Manon", "3 Pointer", 30.0, 80.0)
}