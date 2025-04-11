package com.appdev.all_in_android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.appdev.all_in_android.data.repositories.homeFAQ
import com.appdev.all_in_android.ui.components.HelpScreenContent

@Composable
fun HomeFAQScreen(
    navBack: () -> Unit
) {
    Column {
        HelpScreenContent("How can we help?", "Frequently Asked Questions", homeFAQ, navBack)
    }
}

@Preview
@Composable
private fun HomeFAQScreenPreview() {
    HomeFAQScreen({})
}