package com.appdev.all_in_android.ui.components.profile

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.ui.theme.AllinandroidTheme
import com.appdev.all_in_android.ui.theme.CostRed
import com.appdev.all_in_android.ui.theme.GainGreen
import com.appdev.all_in_android.ui.theme.fontFamily
import com.appdev.all_in_android.ui.theme.gradientBorder
import com.appdev.all_in_android.util.toDollarString
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

@Composable
private fun BarGraphBox(
    gain: Double,
    gainThisTime: Double,
    gainLastTime: Double,
    thisTimeString: String,
    lastTimeString: String,
    gains: List<Double>,
    horizontalLabels: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .gradientBorder()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Header(gain, gainThisTime, gainLastTime, thisTimeString, lastTimeString)
        BarGraph(gains, horizontalLabels)
    }
}

@Composable
fun MonthBarGraphBox(
    gain: Double,
    gainThisMonth: Double,
    gainLastMonth: Double,
    weeklyGains: List<Double>,
    modifier: Modifier = Modifier
) {
    val labels = MutableList(weeklyGains.size) { "" }
    for (i in 1..weeklyGains.size) {
        labels[i - 1] = "Week $i"
    }
    BarGraphBox(
        gain = gain,
        gainThisTime = gainThisMonth,
        gainLastTime = gainLastMonth,
        thisTimeString = "This Month",
        lastTimeString = "Last Month",
        gains = weeklyGains,
        horizontalLabels = labels,
        modifier = modifier
    )
}

@Composable
fun WeekBarGraphBox(
    gain: Double,
    gainThisWeek: Double,
    gainLastWeek: Double,
    dailyGains: List<Double>,
    modifier: Modifier = Modifier,
) {
    BarGraphBox(
        gain = gain,
        gainThisTime = gainThisWeek,
        gainLastTime = gainLastWeek,
        thisTimeString = "This Week",
        lastTimeString = "Last Week",
        gains = dailyGains,
        horizontalLabels = listOf("M", "T", "W", "TH", "F", "S", "SU"),
        modifier = modifier
    )
}

@Composable
private fun Header(
    gain: Double,
    gainThisTime: Double,
    gainLastTime: Double,
    thisTimeString: String,
    lastTimeString: String
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "Gains/Losses",
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            fontSize = 20.sp
        )
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Text(
                text = toDollarString(gain, toInt = true),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Row {
                Text(
                    text = toDollarString(gainThisTime, toInt = false),
                    color = valueToColor(gainThisTime),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = " $thisTimeString", color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Row {
                Text(
                    text = toDollarString(gainLastTime, toInt = false),
                    color = valueToColor(gainLastTime),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = " $lastTimeString", color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun BarGraph(
    values: List<Double>,
    horizontalLabels: List<String>,
    modifier: Modifier = Modifier,
    axisLabelCount: Int = 5,
) {
    if (values.isEmpty() || horizontalLabels.size != values.size) return
    val maxValue = values.max()
    val minValue = values.min()
    val topValue = ceil(max(maxValue, 0.0))
    val bottomValue = floor(min(minValue, 0.0))
    val range = abs(topValue - bottomValue).takeIf { it > 0 } ?: 1.0

    Column(
        modifier = modifier
            .height(164.dp)
    ) {
        var barWidth by remember { mutableStateOf(0.dp) }
        var graphWidth by remember { mutableStateOf(0.dp) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.95f)
        ) {
            // Y-axis labels
            Column(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 0..axisLabelCount) {
                    val labelValue = (topValue - i * (range / axisLabelCount)).roundToInt()
                    Text(
                        text = labelValue.toString(),
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.End),
                        color = Color.White
                    )
                }
            }

            // Bar chart canvas
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val canvasHeight = size.height
                    val canvasWidth = size.width
                    val xStep = canvasWidth / values.size
                    val yZero =
                        ((topValue / range) * canvasHeight).toFloat().coerceIn(0f, canvasHeight)
                    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(5f, 5f), 0f)
                    graphWidth = canvasWidth.toDp()
                    barWidth = (canvasWidth / values.size * 0.6f).toDp()
                    // X-axis
                    drawLine(
                        color = Color.White,
                        start = Offset(0f, yZero),
                        end = Offset(canvasWidth, yZero),
                        strokeWidth = 2f,
                        pathEffect = pathEffect
                    )

                    values.forEachIndexed { index, value ->
                        val barHeight = ((value / range) * canvasHeight).toFloat()
                        val x = index * xStep + (xStep - barWidth.toPx()) / 2f
                        val y = yZero - barHeight
                        val barColor = valueToColor(value)
                        drawRect(
                            color = barColor,
                            topLeft = Offset(x, if (value >= 0) y else yZero),
                            size = androidx.compose.ui.geometry.Size(
                                width = barWidth.toPx(),
                                height = abs(barHeight)
                            )
                        )
                    }
                    drawLine(
                        color = Color.White,
                        start = Offset(0f, canvasHeight),
                        end = Offset(canvasWidth, canvasHeight),
                        strokeWidth = 2f,
                    )
                }
            }
        }

        // X-axis labels
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .weight(0.4f),
            horizontalArrangement = Arrangement.End
        ) {
            horizontalLabels.forEach { label ->
                Text(
                    text = label,
                    fontSize = 12.sp,
                    modifier = Modifier.width((barWidth.value / 0.6f).dp),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview
@Composable
fun BarGraphPreview1() {
    AllinandroidTheme {
        Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
            WeekBarGraphBox(
                gain = 20.0,
                gainThisWeek = -5.0,
                gainLastWeek = 50.0,
                dailyGains = listOf(3000.0, -2500.0, 1250.0, 4950.0, -4000.0, 2500.0, 2700.0),
                modifier = Modifier.fillMaxWidth(),
            )
            MonthBarGraphBox(
                gain = 20.0,
                gainThisMonth = -5.0,
                gainLastMonth = 50.0,
                weeklyGains = listOf(3000.0, -2500.0, 1250.0, 4950.0),
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}


private fun valueToColor(amount: Double) =
    if (amount > 0) GainGreen else CostRed

