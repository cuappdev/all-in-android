package com.appdev.all_in_android.ui.screens

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.appdev.all_in_android.ui.components.general.PlayerCard
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerSeeAllScreen(
    navController: NavController
){
    val playerCardInfoList = listOf(
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        ),
        PlayerCardInfo(
            playerName = "C. Manon",
            playerNumber = 14,
            playerPosition = "PG",
            onClick = {
                navController.navigate("Buy Contract")
            }
        )
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        ""
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Home")
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF15141B),
                )
            )
        },
        containerColor = Color(0xFF15141B)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding(),
                )
                .verticalScroll(
                    rememberScrollState()
                )
            ,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Player Packs",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(24.dp)
            )
            AutoScrollingLazyRow(
                list = playerCardInfoList
            ) {
                PlayerCard(
                    playerName = it.playerName,
                    playerNumber = it.playerNumber,
                    playerPosition = it.playerPosition,
                    onClick = it.onClick
                )
            }
            AutoScrollingLazyRow(
                list = playerCardInfoList,
                scrollDx = 48f
            ) {
                PlayerCard(
                    playerName = it.playerName,
                    playerNumber = it.playerNumber,
                    playerPosition = it.playerPosition,
                    onClick = it.onClick
                )
            }
            AutoScrollingLazyRow(
                list = playerCardInfoList
            ) {
                PlayerCard(
                    playerName = it.playerName,
                    playerNumber = it.playerNumber,
                    playerPosition = it.playerPosition,
                    onClick = it.onClick
                )
            }
            AutoScrollingLazyRow(
                list = playerCardInfoList,
                scrollDx = 32f
            ) {
                PlayerCard(
                    playerName = it.playerName,
                    playerNumber = it.playerNumber,
                    playerPosition = it.playerPosition,
                    onClick = it.onClick
                )
            }

        }
    }

}

private const val SCROLL_DX = 24f
private const val REQUIRED_CARD_COUNT = 8

private class AutoScrollItem<T>(
    val id: String = UUID.randomUUID().toString(),
    val data: T
)

@Composable
fun <T : Any> AutoScrollingLazyRow(
    list: List<T>,
    modifier: Modifier = Modifier,
    scrollDx : Float = SCROLL_DX,
    itemContent: @Composable (item: T) -> Unit,
) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    var items by remember { mutableStateOf(list.mapAutoScrollItem()) }

    LazyRow(
        state = lazyListState,
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            18.dp
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(
            items, key = { _, item -> item.id }
        ) { index, item ->
            itemContent(item.data)

            if (index == items.lastIndex) {
                val currentList = items
                val firstVisibleItemIndex = lazyListState.firstVisibleItemIndex
                val secondPart = currentList.subList(0, firstVisibleItemIndex)
                val firstPart =
                    currentList.subList(firstVisibleItemIndex, currentList.size)

                LaunchedEffect(key1 = Unit) {
                    coroutineScope.launch {
                        lazyListState.scrollToItem(
                            0,
                            maxOf(0, lazyListState.firstVisibleItemScrollOffset - scrollDx.toInt())
                        )
                    }
                }

                items = (firstPart + secondPart)
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        coroutineScope.launch {
            while (true) {
                lazyListState.autoScroll(
                    scroll_dx = scrollDx
                )
            }
        }
    }
}

private fun <T : Any> List<T>.mapAutoScrollItem(): List<AutoScrollItem<T>> {
    val newList = this.map { AutoScrollItem(data = it) }.toMutableList()
    var index = 0
    if (this.size < REQUIRED_CARD_COUNT) {
        while (newList.size != REQUIRED_CARD_COUNT) {
            if (index > this.size - 1) {
                index = 0
            }

            newList.add(AutoScrollItem(data = this[index]))
            index++
        }
    }
    return newList
}

suspend fun ScrollableState.autoScroll(
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 800, easing = LinearEasing),
    scroll_dx : Float = SCROLL_DX
) {
    var previousValue = 0f
    scroll(MutatePriority.PreventUserInput) {
        animate(0f, scroll_dx, animationSpec = animationSpec) { currentValue, _ ->
            previousValue += scrollBy(currentValue - previousValue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerSeeAllScreenPreview(){
//    PlayerSeeAllScreen()
}