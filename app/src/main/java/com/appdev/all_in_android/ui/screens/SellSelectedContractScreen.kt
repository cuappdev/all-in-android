package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.components.general.BetCard
import com.appdev.all_in_android.ui.components.general.SellContractPrice
import com.appdev.all_in_android.ui.theme.backgroundBlue

@Composable
fun SellSelectedContractScreen(
    onBackClick: () -> Unit = {},
    onConfirmClick: (Double) -> Unit = {}
) {
    var price by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(backgroundBlue)
            .fillMaxSize()
            .padding(24.dp)
    ) {

        // Back Arrow
        Image(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = "Back",
            modifier = Modifier
                .size(24.dp)
                .clickable { onBackClick() }
        )
        Spacer(Modifier.height(40.dp))
        Text(
            text = "Jake Shane v. Harvard",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(
            text = "03/24 | Men’s Ice Hockey",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(
            text = "Scores first goal of game",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(Modifier.height(28.dp))
        SellContractPrice()
        // Set a Price Section
        Spacer(Modifier.height(120.dp))
        Text(
            text = "Set a price",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_currency_dollar_circle),
                    contentDescription = "Dollar Icon",
                    modifier = Modifier.size(72.dp)
                )


                        BasicTextField(
                            value = price,
                            onValueChange = { input ->
                                if (input.all { it.isDigit() }) {
                                    price = input
                                }
                            },
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 64.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier.padding(start = 12.dp),
                            decorationBox = { innerTextField ->
                                if (price.isBlank()) {
                                    Text(
                                        text = "---",
                                        color = Color.Gray,
                                        fontSize = 64.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                innerTextField()
                            }
                        )


            }
        }


        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        Spacer(Modifier.height(80.dp))
        // Description
        Text(
            text = "When you confirm to sell, it means you’re placing this contract on the marketplace where other All In users will be able to buy it at the price you set.",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            )
        )

        Spacer(Modifier.weight(1f))

        // Confirm Button
        Button(
            onClick = { onConfirmClick(price.toDoubleOrNull() ?: 0.0) },
            enabled = price.isNotBlank(),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues()
        ) {
            Text(
                text = "Confirm to Sell",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun SellSelectedContractScreenPreview() {
    SellSelectedContractScreen()
}