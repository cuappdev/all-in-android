package com.appdev.all_in_android.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RarityChestBottomSheet(
    rarity: String,
    cost: Int,
    sheetState: SheetState,
    onDismiss: () -> Unit
) {

//    ModalBottomSheet(
//        sheetState = sheetState,
//        sheetContent = {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                RarityChest(
//                    rarity = rarity,
//                    cost = cost
//                )
//            }
//        },
//        onDismiss = onDismiss
//    )

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
        RarityChestBottomSheet(
            rarity = "Legendary",
            cost = 3320,
            sheetState = sheetState,
            onDismiss = { showBottomSheetState = false }
        )
    }
}
