package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.appdev.all_in_android.data.repositories.betTrackerFAQ
import com.appdev.all_in_android.ui.components.HelpScreenContent

@Composable
fun BetTrackerFAQScreen(
    navBack: () -> Unit
){
    Column{
        HelpScreenContent("How can we help?", "Frequently Asked Questions", betTrackerFAQ, navBack)
    }
}

@Preview
@Composable
private fun BetTrackerFAQScreenPreview(){
    BetTrackerFAQScreen({})
}

