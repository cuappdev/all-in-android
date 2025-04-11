package com.appdev.all_in_android.ui.components.general

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .width(345.dp)
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val icons= listOf(R.drawable.ic_home, R.drawable.ic_marketplace,R.drawable.ic_bet_tracker)
        val labels = listOf("Home", "Marketplace", "Bet Tracker")
        for (i in 0..2) {
            Item(icons[i], labels[i])
        }
    }
}

@Composable
private fun Item(icon: Int, label: String) {
    Column(
        modifier = Modifier.width(76.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = label,
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 12.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    BottomBar()
}