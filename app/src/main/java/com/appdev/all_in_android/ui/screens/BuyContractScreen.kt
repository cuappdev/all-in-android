package com.appdev.all_in_android.ui.screens
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.components.general.BetCard
import com.appdev.all_in_android.ui.components.general.SellContractPrice
import com.appdev.all_in_android.ui.theme.backgroundBlue
import com.appdev.all_in_android.ui.theme.gradientBorder
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatScreen(
    nextScreen: () -> Unit,
    navController: NavController
) {
    // State for bottom sheet
    var showChartBottomSheet by remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(backgroundBlue)
            .fillMaxSize()
            .padding(24.dp)
    ) {
        // Back Arrow
        Image(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = "Back",
            modifier = Modifier
                .size(24.dp)
                .clickable(onClick = { navController.popBackStack() })
        )

        // Content remains the same
        Spacer(Modifier.height(40.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "C. Manon v. Harvard",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Text(
                    text = "03/24 | Men's Ice Hockey",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Image(
                painter = painterResource(id = R.drawable.player_photo),
                contentDescription = "C. Manon Photo",
                modifier = Modifier
                    .size(64.dp)
                    .border(2.dp, Color.White,)
            )
        }

        Spacer(Modifier.height(28.dp))
        SellContractPrice()
        Spacer(Modifier.height(120.dp))

        // Always show historical block
        HistoricalStatBlock(onButtonClick = { showChartBottomSheet = true })

        Spacer(Modifier.weight(1f))
        // Confirm Button
        val gradientBrush = Brush.linearGradient(
            colors = listOf(
                Color(0xFF1F70C7),
                Color(0xFF7DF3FE),
                Color(0xFF887DFE),
                Color(0xFF7D97FE)
            )
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(
                    brush = gradientBrush,
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable(
                    onClick = nextScreen,
                    indication = null,
                    interactionSource = null
                ),
        ) {
            Text(
                "Confirm to Buy",
                color = Color(0xFF15141B),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }

    // Chart Bottom Sheet
    if (showChartBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showChartBottomSheet = false },
            sheetState = bottomSheetState,
            containerColor = Color(0xFF0D0C1E)
        ) {
            // State to track selected tab
            var selectedTab by remember { mutableStateOf("PTS") }

            // Define data for each stat category
            val statData = mapOf(
                "PTS" to listOf(18f, 15f, 21f, 14f, 19f),
                "Rebounds" to listOf(8f, 6f, 10f, 7f, 9f),
                "FGM" to listOf(7f, 5f, 9f, 6f, 8f),
                "FGA" to listOf(14f, 12f, 16f, 13f, 15f),
                "TPM" to listOf(3f, 2f, 4f, 1f, 3f),
                "TPA" to listOf(7f, 6f, 9f, 5f, 8f)
            )

            // Define average values for each stat
            val avgValues = mapOf(
                "PTS" to 17.4f,
                "Rebounds" to 8.0f,
                "FGM" to 7.0f,
                "FGA" to 14.0f,
                "TPM" to 2.6f,
                "TPA" to 7.0f
            )

            // Define max scale values for each stat
            val maxValues = mapOf(
                "PTS" to 25f,
                "Rebounds" to 12f,
                "FGM" to 10f,
                "FGA" to 20f,
                "TPM" to 5f,
                "TPA" to 10f
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("C. Manon #14 | PG", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Icon(
                        painter = painterResource(id = R.drawable.ic_white_x_close),
                        contentDescription = "Close",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                coroutineScope.launch {
                                    bottomSheetState.hide()
                                    showChartBottomSheet = false
                                }
                            }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                val tabs = listOf("PTS", "Rebounds", "FGM", "FGA", "TPM", "TPA")

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {
                    items(tabs.size) { index ->
                        val tabName = tabs[index]
                        val isSelected = tabName == selectedTab
                        Box(
                            modifier = Modifier
                                .gradientBorder()
                                .background(
                                    if (isSelected) Color(0xFF1F70C7) else Color(0xFF15141B),
                                    RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                                .clickable { selectedTab = tabName }
                        ) {
                            Text(tabName, color = Color.White, fontSize = 14.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .gradientBorder()
                        .background(Color(0xFF201E2D), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    // Use data based on the selected tab
                    SimpleBarChart(
                        barData = statData[selectedTab] ?: listOf(0f, 0f, 0f, 0f, 0f),
                        avg = avgValues[selectedTab] ?: 0f,
                        max = maxValues[selectedTab] ?: 1f
                    )
                }

                // Rest of the UI remains the same
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dollar_circle),
                        contentDescription = "dollar circle",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "1,720",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "contains a contract involving C. Manon",
                    color = Color(0xFF979797),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(16.dp))

                val gradientBrush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF1F70C7),
                        Color(0xFF7DF3FE),
                        Color(0xFF887DFE),
                        Color(0xFF7D97FE)
                    )
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .background(
                            brush = gradientBrush,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable(
                            onClick = {
                                coroutineScope.launch {
                                    bottomSheetState.hide()
                                    showChartBottomSheet = false
                                    nextScreen()
                                }
                            }
                        ),
                ) {
                    Text(
                        "Confirm to Buy",
                        color = Color(0xFF15141B),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun SimpleBarChart(
    barData: List<Float>,
    avg: Float,
    max: Float
) {
    // State to track which bar is selected
    var selectedBarIndex by remember { mutableStateOf(0) } // Default to first bar
    val barWidth = 30.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            barData.forEachIndexed { index, value ->
                val heightRatio = value / max
                val isSelected = index == selectedBarIndex

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // Show value if selected
                    if (isSelected) {
                        Text(
                            text = value.toInt().toString(),
                            color = Color(0xFFF97066),
                            fontSize = 12.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height((heightRatio * 140).dp)
                            .width(barWidth)
                            .background(
                                if (isSelected) Color(0xFFF97066) else Color.White,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .clickable { selectedBarIndex = index }
                    )
                }
            }
        }

        Text(
            text = "Avg: $avg",
            color = Color.LightGray,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 8.dp)
        )
    }
}

@Composable
fun HistoricalStatBlock(onButtonClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0D0C1E))
            .padding(16.dp)
    ) {
        HistoricalDataButton(onClick = onButtonClick)
        Spacer(modifier = Modifier.height(16.dp))
        StatChart()
    }
}

@Composable
fun HistoricalDataButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, Color(0xFF9AA0FF)),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(
            text = "Click to see historical data",
            color = Color.White
        )
    }
}

@Composable
fun StatChart() {
    val gradientBrush = Brush.horizontalGradient(
        listOf(Color(0xFF9CDCF4), Color(0xFFB39DFF))
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E1E2F), shape = RoundedCornerShape(12.dp))
            .padding(1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = gradientBrush)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf(" ", "G", "PTS", "TRB", "AST").forEach {
                Text(
                    text = it,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        val rows = listOf(
            listOf("24-25", "33", "6.6", "3.7", "1.3"),
            listOf("Career", "116", "9.9", "3.8", "2.1")
        )

        rows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF121223))
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach {
                    Text(
                        text = it,
                        color = Color.White,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun ChartScreen(onBack: () -> Unit, nextScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0C1E))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("C. Manon #14 | PG", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Icon(
                painter = painterResource(id = R.drawable.ic_white_x_close),
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = onBack)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val tabs = listOf("PTS", "Rebounds", "FGM", "FGA", "TPM", "TPA")

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            items(tabs.size) { title ->
                val isSelected = tabs[title] == "FGM"
                Box(
                    modifier = Modifier
                        .background(
                            if (isSelected) Color(0xFF1F70C7) else Color(0xFF15141B),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .gradientBorder()
                ) {
                    Text(tabs[title], color = Color.White, fontSize = 14.sp)
                }
            }
        }


        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFF201E2D), shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
                .gradientBorder()
        ) {
            SimpleBarChart()
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dollar_circle),
                contentDescription = "dollar circle",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "1,720",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "contains a contract involving C. Manon",
            color = Color(0xFF979797),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        val gradientBrush = Brush.linearGradient(
            colors = listOf(
                Color(0xFF1F70C7),
                Color(0xFF7DF3FE),
                Color(0xFF887DFE),
                Color(0xFF7D97FE)
            )
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(
                    brush = gradientBrush,
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable(
                    onClick = nextScreen,
                    indication = null,
                    interactionSource = null
                ),
        ) {
            Text(
                "Confirm to Buy",
                color = Color(0xFF15141B),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun SimpleBarChart() {
    val barData = listOf(12f, 10f, 14f, 17f, 11f)
    val avg = 13.4f
    val max = 20f
    val barWidth = 30.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            barData.forEachIndexed { index, value ->
                val heightRatio = value / max
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (index == 0) {
                        Text(
                            text = value.toInt().toString(),
                            color = Color(0xFFF97066),
                            fontSize = 12.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height((heightRatio * 140).dp)
                            .width(barWidth)
                            .background(
                                if (index == 0) Color(0xFFF97066) else Color.White,
                                shape = RoundedCornerShape(4.dp)
                            )
                    )
                }
            }
        }

        Text(
            text = "Avg: $avg",
            color = Color.LightGray,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 8.dp)
        )
    }
}
//@Preview(showBackground = true)
//@Composable
//private fun BuyContractScreenPreview() {
//    StatScreen()
//}