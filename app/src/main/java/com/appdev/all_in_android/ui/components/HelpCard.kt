package com.appdev.all_in_android.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HelpCard(
    text: String
){
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(color = Color(0xff201E2D), shape = RoundedCornerShape(35))
            .padding(16.dp),
        //horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Canvas(
            modifier = Modifier
                .size(24.dp)
                .padding(2.dp)
        ) {
            drawCircle(color = Color(0xff1F70C7))
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 16.sp, color = Color.White)
    }
}

@Composable
fun HelpCardExpanded(){

}

@Preview
@Composable
private fun HelpCardPreview(){
    HelpCard("some faq")
}
