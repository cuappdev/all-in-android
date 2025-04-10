package com.appdev.all_in_android.ui.components.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CartRowItem(
    title: String,
    cost: Int,
    subLine: String
){
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                "${title}",
                fontSize = 14.sp,
                color = Color.White
            )
            Text(
                "$${cost}",
                color = Color.White
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Text(
                text = subLine,
                fontSize = 10.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun CartRowItemPreview(){
    CartRowItem(
        "Name 3-Pointer",
        30,
        "Win ${80} if true"
    )
}