package com.appdev.all_in_android.ui.components.general

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
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
import androidx.compose.ui.tooling.preview.Preview
import com.appdev.all_in_android.ui.components.home.RarityChestSheetContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllInBottomSheet(
    showBottomSheetState: Boolean,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    bottomSheetType: BottomSheetType,
    rarityChestContent: RarityChestContent = RarityChestContent("", 0, {})
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
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = Color.White,
        ) {
            when (bottomSheetType) {
                BottomSheetType.RARITY_CHEST -> RarityChestSheetContent(
                    rarityChestContent.rarity,
                    onDismiss,
                    rarityChestContent.cost,
                    rarityChestContent.onBuyNow
                )

                BottomSheetType.PLAYER_CARD -> {}
            }
        }
    }
}

enum class BottomSheetType {
    RARITY_CHEST,
    PLAYER_CARD
}

data class RarityChestContent(
    val rarity: String,
    val cost: Int,
    val onBuyNow: () -> Unit
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AllInBottomSheetPreview() {
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
            AllInBottomSheet(
                showBottomSheetState = showBottomSheetState,
                sheetState = sheetState,
                onDismiss = { showBottomSheetState = false },
                bottomSheetType = BottomSheetType.RARITY_CHEST,
                rarityChestContent = RarityChestContent("Common", 100, {})
            )
        }
    }
}