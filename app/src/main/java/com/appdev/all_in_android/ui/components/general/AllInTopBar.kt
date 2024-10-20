package com.appdev.all_in_android.ui.components.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllInTopBar(
    title: String,
    money: Int
) {
    MediumTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
    )

}

@Preview(showBackground = true)
@Composable
private fun AllInTopBarPreview() {
    Scaffold(topBar = {
        AllInTopBar(
            title = "Profile",
            money = 1000
        )
    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White)
        ){

        }

    }
}