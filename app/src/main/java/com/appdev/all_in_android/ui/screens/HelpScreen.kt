package com.appdev.all_in_android.ui.screens

import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.theme.backgroundBlue

@Composable
fun HelpScreen(){
    Column(
        modifier = Modifier
            .background(color = backgroundBlue)
            .padding(horizontal = 24.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(44.dp))

        Image(
            painter = painterResource(R.drawable.ic_back_arrow),
            contentDescription = "back arrow"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "How can we help?",
            fontSize = 24.sp,
            color = Color.White
        )
        Text(
            "Frequently Asked Questions",
            fontSize = 15.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview
@Composable
private fun HelpScreenPreview(){
    HelpScreen()
}