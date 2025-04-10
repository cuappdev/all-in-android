package com.appdev.all_in_android.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class HelpCardData(
    val title: String,
    val body: String,
)

@Composable
fun HelpCard(
    title: String,
    body: String,
) {
    var isExpanded by remember { mutableStateOf(false) }

    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFF1F70C7), Color(0xFF7DF3FE), Color(0xFF887DFE), Color(0xFF7D97FE))
    )

    // Animate the color of the circle
    val circleColor by animateColorAsState(
        targetValue = if (isExpanded) Color(0xff1F70C7) else Color(0xff99C5F4),
        animationSpec = tween(durationMillis = 300)
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xff201E2D), shape = RoundedCornerShape(12))
                .border(width = 1.dp, brush = gradientBrush, shape = RoundedCornerShape(12))
                .padding(16.dp)
                .clickable(onClick = { isExpanded = !isExpanded }),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Canvas(
                modifier = Modifier
                    .size(18.dp)
                    .padding(2.dp)
            ) {
                drawCircle(color = circleColor)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(title, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(animationSpec = tween(300)) + fadeIn(),
            exit = shrinkVertically(animationSpec = tween(300)) + fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(animationSpec = tween(100))
                    .padding(start = 12.dp, bottom = 12.dp, end = 12.dp)
                    .background(color = Color(0xff201E2D))
                    .padding(12.dp)

            ) {
                Text(body, color = Color.White)
            }
        }
    }
}


@Preview
@Composable
private fun HelpCardPreview() {
    HelpCard(
        "What is sports betting?",
        "Sports betting is the act of placing a wager on the outcome of a sporting event. It allows individuals to bet on various aspects of a game, such as which team will win, the final score, or specific player performances.",
    )
}
