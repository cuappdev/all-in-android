package com.appdev.all_in_android.ui.components.marketplace

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SheetState
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.appdev.all_in_android.ui.theme.Background2
import com.appdev.all_in_android.ui.theme.gradientBrush

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterBottomSheet(
    padding: PaddingValues,
    onDismissRequest: () -> Unit,
    sheetState: SheetState
) {
    ModalBottomSheet (
        modifier = Modifier.fillMaxHeight(),
        onDismissRequest = onDismissRequest, sheetState = sheetState,
        containerColor = Background2,
        scrimColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 19.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Filters",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(brush = gradientBrush)
        )
        LazyColumn(modifier = Modifier.padding(horizontal = 23.dp)) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 34.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Sort by",
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 19.sp,
                        lineHeight = 19.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Any",
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                            fontSize = 19.sp,
                            lineHeight = 19.sp
                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                                contentDescription = "down",
                                tint = Color.White
                            )
                        }
                        Box {
                        }
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(brush = gradientBrush)
                )
            }
            item {
                Text(
                    text = "Price range",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 19.sp,
                    lineHeight = 19.sp, modifier = Modifier.padding(bottom = 15.dp, top = 23.dp)
                )
            }
            item {
                Text(
                    text = "Any",
                    color = Color.White,
                    fontSize = 19.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            item {
                RangeSliderExample()
            }
            item {
                Text(
                    text = "Payout range",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 19.sp,
                    lineHeight = 19.sp, modifier = Modifier.padding(bottom = 15.dp, top = 23.dp)
                )
                Text(
                    text = "Any",
                    color = Color.White,
                    fontSize = 19.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                RangeSliderExample()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(brush = gradientBrush)
                )
                Text(
                    text = "Sport",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 19.sp,
                    lineHeight = 19.sp, modifier = Modifier.padding(bottom = 15.dp, top = 23.dp)
                )
                val selectedSports =
                    remember { mutableStateListOf(false, false, false, false, false, false, false) }
                val sports = listOf(
                    "Basketball",
                    "Hockey",
                    "Baseball",
                    "Swim",
                    "Volleyball",
                    "Track & Field",
                    "Tennis"
                )
                FlowRow {
                    for (i in 1..7) {
                        ChipItem(
                            text = sports[i - 1],
                            onClick = { selectedSports[i - 1] = !selectedSports[i - 1] },
                            selected = selectedSports[i - 1]
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(brush = gradientBrush)
                )
                Text(
                    text = "Rarity Level",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 19.sp,
                    lineHeight = 19.sp, modifier = Modifier.padding(bottom = 15.dp, top = 23.dp)
                )

                val selectedRarity =
                    remember { mutableStateListOf(false, false, false, false) }
                val rarities = listOf(
                    "Common", "Epic", "Rare", "Legendary"
                )
                FlowRow {
                    for (i in 1..4) {
                        ChipItem(
                            text = rarities[i - 1],
                            onClick = { selectedRarity[i - 1] = !selectedRarity[i - 1] },
                            selected = selectedRarity[i - 1]
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Reset",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 17.sp
                    )
                    Button(onClick = {}) {
                        Text(
                            "Apply Filters",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }
                }

            }
        }

    }
}

@Composable
fun ChipItem(text: String, onClick: () -> Unit = {}, selected: Boolean) {
    FilterChip(
        modifier = Modifier.padding(end = 4.dp),
        onClick = onClick,
        leadingIcon = {},
        border = BorderStroke(1.dp, Color(0xFF3B3A3C)),
        label = {
            Text(text)
        },
        colors = SelectableChipColors(
            containerColor = if (selected) Color(0xFF1F70C7) else Color.Transparent,
            labelColor = Color.White,
            leadingIconColor = Color.Blue,
            trailingIconColor = Color.Blue,
            disabledContainerColor = Color.Gray,
            disabledLabelColor = Color.Black,
            disabledLeadingIconColor = Color.Gray,
            disabledTrailingIconColor = Color.Gray,
            selectedContainerColor = Color(0xFF1F70C7),
            disabledSelectedContainerColor = Color.Gray,
            selectedLabelColor = Color.White,
            selectedLeadingIconColor = Color.White,
            selectedTrailingIconColor = Color.White
        ),
        selected = selected
    )
}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..10000f) }
    Column(modifier = Modifier.padding(bottom = 22.dp)) {
        RangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..10000f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            colors = SliderDefaults.colors(Color(0xFF7D97FE))
        )
        val start = sliderPosition.start
        val end = sliderPosition.endInclusive
        Text(
            text = "${String.format("%.2f", start)}..${String.format("%.2f", end)}",
            color = Color.White,
            fontSize = 12.sp
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun FilterBottomSheetPreview() {
    val sheetState =
        rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(true) }
    Scaffold(
    ) { padding ->
        // Screen content
        FilterBottomSheet(
            padding = padding,
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        )
    }

}