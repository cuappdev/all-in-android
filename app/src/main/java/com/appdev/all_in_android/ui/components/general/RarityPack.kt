package com.appdev.all_in_android.ui.components.general

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.appdev.all_in_android.ui.theme.gradientBorder

@Composable
fun RarityPack(
    rarity: String,
    onClick: () -> Unit
) {
    val rarityImageId = when (rarity) {
        "Rare" -> R.drawable.ic_rare
        "Epic" -> R.drawable.ic_epic
        "Legendary" -> R.drawable.ic_legendary
        else -> R.drawable.ic_common
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .clickable(
                onClick = onClick
            )
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(164.dp)
                .gradientBorder()
                .background(
                    color = Color(0xFF201E2D),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Icon(
                painter = painterResource(rarityImageId),
                contentDescription = "$rarity image",
                tint = Color.Unspecified
            )
        }
        Text(
            text = rarity,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun RarityPackPreview() {
    RarityPack(
        rarity = "Epic"
    ) {}
}