package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.appdev.all_in_android.data.repositories.homeFAQ
import com.appdev.all_in_android.ui.components.HelpScreenContent

@Composable
fun HomeFAQScreen() {
    Column {
        HelpScreenContent("How can we help?", "Frequently Asked Questions", homeFAQ)
    }
}

@Preview
@Composable
private fun HomeFAQScreenPreview() {
    HomeFAQScreen()
}