package com.appdev.all_in_android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.theme.backgroundBlue

@Composable
fun HelpScreenContent(
    heading: String,
    subtext: String,
    questionsList: List<HelpCardData>,
    navBack: () -> Unit
){
    Column(
        modifier = Modifier
            .background(color = backgroundBlue)
            .padding(horizontal = 24.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(44.dp))

        Box(
            modifier = Modifier.clickable(onClick = {navBack()})
        ){
            Image(
                painter = painterResource(R.drawable.ic_back_arrow),
                contentDescription = "back arrow"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            heading,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            subtext,
            fontSize = 15.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(questionsList) { helpCard ->
                HelpCard( helpCard.title, helpCard.body)
            }
        }
    }
}

@Preview
@Composable
private fun HelpScreenContentPreview(){
    val body = "Sports betting is the act of placing a wager on the outcome of a sporting event. It allows individuals to bet on various aspects of a game, such as which team will win, the final score, or specific player performances."
    val questions = listOf(
        HelpCardData("What is sports betting?", body),
        HelpCardData("Another Question", body)
    )
    HelpScreenContent("How can we help?", "Frequently Asked Questions", questions, {})
}