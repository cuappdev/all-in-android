package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.theme.gradientBrush

@Composable
fun RankingsScreen(
    navController: NavController
) {
    val backgroundColor = Color(0xFF15141B)
    val tabs = listOf("Today", "This week", "All time")
    var selectedTabIndex by remember { mutableStateOf(0) }
    val rankingInfoList = listOf(
        RankingInfo(
            name = "andrewcheung",
            money = 5000,
            ranking = 4,
            change = 4
        ),
        RankingInfo(
            name = "amywang",
            money = 4000,
            ranking = 5,
            change = 3
        ),
        RankingInfo(
            name = "emiljiang",
            money = 3000,
            ranking = 6,
            change = 1
        ),
        RankingInfo(
            name = "calebshim",
            money = 2000,
            ranking = 7,
            change = 2
        ),
        RankingInfo(
            name = "jiwonjeong",
            money = 1000,
            ranking = 8,
            change = 3
        ),

        )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Top Bar with Back Button
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                IconButton(onClick = { navController.navigate("Home") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Rankings",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Tabs
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color(0xFF201E2D),
                contentColor = Color.White,
                indicator = { tabPositions ->
                    Box {}  // No indicator as we'll style the tabs individually
                },
                divider = { /* No divider */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .height(48.dp)
                    .border(
                        width = 1.dp,
                        brush = gradientBrush,
                        shape = RoundedCornerShape(24.dp)
                    )
            ) {
                tabs.forEachIndexed { index, title ->
                    val selected = selectedTabIndex == index
                    Tab(
                        selected = selected,
                        onClick = { selectedTabIndex = index },
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                if (selected) Color(0xFF1F70C7) else Color.Transparent
                            )
                    ) {
                        Text(
                            text = title,
                            color = if (selected) Color.White else Color.Gray,
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Image(
                painter = painterResource(id = R.drawable.ranking_medals),
                contentDescription = "Ranking Background",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(
                        horizontal = 24.dp
                    )
            )

            Spacer(modifier = Modifier.height(16.dp))

            RankingList(
                rankingInfoList
            )
        }
    }
}

@Composable
fun MedalWithRibbon(medal: Int, medalColor: Color) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        // Ribbon
        Box(
            modifier = Modifier
                .size(width = 12.dp, height = 24.dp)
                .background(Color(0xFF2196F3))
                .align(Alignment.TopCenter)
        )

        // Medal
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(medalColor)
        ) {
            Text(
                text = medal.toString(),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun UserAvatarWithName(
    username: String,
    points: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // We'd use an actual avatar here, but for simplicity using a colored box
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = username,
            color = Color.White,
            fontSize = 14.sp
        )

        Text(
            text = "$ $points",
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}

@Composable
fun RankingListItem(
    rank: Int,
    username: String,
    points: Int
) {
    Card(
        colors = CardColors(
            containerColor = Color(0xFF232323),
            contentColor = Color.White,
            disabledContainerColor = Color(0xFF232323),
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Avatar (placeholder)
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Username
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = username,
                        color = Color.White,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    // Tree icon
                    Text(
                        text = "🌳",
                        fontSize = 14.sp
                    )
                }

                Text(
                    text = "$ $points",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Rank
            Text(
                text = "#$rank",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RankingsScreenPreview() {
    MaterialTheme {
//        RankingsScreen()
    }
}