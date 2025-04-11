package com.appdev.all_in_android.ui.components.general

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.appdev.all_in_android.ui.theme.gradientBorder

@Composable
fun SellContractPrice(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .gradientBorder()
            .background(
                color = Color(0xFF201E2D),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CostGainTextBody(20.0, 40.0)
    }

}
@Composable
private fun CostGainTextBody(cost: Double, gain: Double) {
    Column(
        modifier = Modifier.fillMaxWidth(), // Make column fill row's width
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Center children horizontally
    ) {
        Text(
            text = "Cost: $cost",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFF97066)
        )
        Text(
            text = "Gain: $gain",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF47CD89)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SellContractPricePreview() {
    SellContractPrice()
}