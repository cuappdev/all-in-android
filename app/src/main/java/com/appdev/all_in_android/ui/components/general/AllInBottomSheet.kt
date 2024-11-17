package com.appdev.all_in_android.ui.components.general

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
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

//@Preview(showBackground = true)
//@Composable
//fun AllInBottomSheetPreview() {
//    AllInBottomSheet(
//        showBottomSheetState = true,
//        sheetState = SheetState(),
//        onDismiss = {},
//        bottomSheetType = BottomSheetType.RARITY_CHEST
//    )
//}