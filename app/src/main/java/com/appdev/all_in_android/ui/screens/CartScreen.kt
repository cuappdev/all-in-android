package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appdev.all_in_android.ui.components.cart.CardHeader
import com.appdev.all_in_android.ui.theme.DefaultGray

@Composable
fun CartScreen(){
    val cartTotal = 100
    val winAmt = 1540
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        CardHeader()

        LazyColumn(
            modifier = Modifier
        ){

        }

        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 40.dp),

        ){
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = DefaultGray),//androidx.compose.material3.ButtonDefaults(containerColor = DefaultGray),
                onClick = {}
            ){
                Text("Confirm spend $${cartTotal} to win $${winAmt}")
            }
        }
    }
}

@Preview
@Composable
fun CartScreenPreview(){
    CartScreen()
}