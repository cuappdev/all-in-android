package com.appdev.all_in_android.ui.components.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.components.general.BuyButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RarityChestBottomSheet(
    showBottomSheetState: Boolean,
    rarity: String,
    cost: Int,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    onBuyNow: () -> Unit = { }
) {
    AnimatedVisibility(
        visible = showBottomSheetState,
        enter = slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(300)
        ),
        exit = slideOutVertically(
            targetOffsetY = { it },
            animationSpec = tween(300)
        )
    ) {
        RarityChestBottomSheetContent(onDismiss, sheetState, rarity, cost, onBuyNow)
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun RarityChestBottomSheetContent(
    onDismiss: () -> Unit,
    sheetState: SheetState,
    rarity: String,
    cost: Int,
    onBuyNow: () -> Unit
) {

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Color.White,
    ) {
        RarityChestSheetContent(rarity, onDismiss, cost, onBuyNow)

    }
}

@Composable
fun RarityChestSheetContent(
    rarity: String,
    onDismiss: () -> Unit,
    cost: Int,
    onBuyNow: () -> Unit
) {
    val imageMap = mapOf(
        "Common" to R.drawable.common_chest,
        "Rare" to R.drawable.rare_chest,
        "Epic" to R.drawable.epic_chest,
        "Legendary" to R.drawable.legendary_chest
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp),
        verticalArrangement = Arrangement.spacedBy(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SheetHeader(rarity, onDismiss)
            Image(
                painter = painterResource(id = imageMap[rarity]!!),
                contentDescription = null,
                modifier = Modifier
                    .width(111.dp)
                    .height(96.dp)
            )
            CostRow(cost)
            Text(
                text = "Contains a ${rarity.lowercase()} contract",
                fontSize = 17.sp,
                color = Color(0xFF979797)
            )
        }
        BuyButton(onBuyNow = onBuyNow)
    }
}

@Composable
private fun CostRow(cost: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 26.dp,
                end = 26.dp,
            ),
        horizontalArrangement = Arrangement.spacedBy(
            4.dp,
            Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_black_money),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Text(
            text = cost.toString(),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}


@Composable
private fun SheetHeader(rarity: String, onDismiss: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .padding(
                start = 26.dp,
                end = 26.dp,
            ),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = "$rarity Chest",
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF050505)

        )
        Surface(
            shape = CircleShape,
            color = Color(0xFFEFF1F4),
            modifier = Modifier
                .size(40.dp)
                .clickable { onDismiss() }
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = Color(0xFF050505),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RarityChestBottomSheetPreview() {
    var showBottomSheetState by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Click to show bottom sheet",
            modifier = Modifier.clickable { showBottomSheetState = true }
        )
        if (showBottomSheetState) {
            RarityChestBottomSheet(
                showBottomSheetState = showBottomSheetState,
                rarity = "Rare",
                cost = 3320,
                sheetState = sheetState,
                onDismiss = { showBottomSheetState = false }
            )
        }
    }
}
