package com.appdev.all_in_android.ui.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.ui.components.general.AllInTopBar
import com.appdev.all_in_android.ui.components.profile.PhotoPicker

@Composable
fun ProfileScreen(
    userName : String = "",
    money: Int = 0,
    imageUri: Uri? = null,
    onPhotoSelected: (Uri) -> Unit = {},
    numActiveContracts: Int = 0,
    numPastContracts: Int = 0
) {
    Scaffold(
        topBar = { AllInTopBar(title = "Profile", money = money) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F7))
                .padding(
                    top = innerPadding.calculateTopPadding() + 16.dp,
                    start = 32.dp,
                    end = 32.dp
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            ProfileHeader(
                imageUri = imageUri,
                onPhotoSelected = onPhotoSelected,
                name = userName,
                numActiveContracts = numActiveContracts,
                numPastContracts = numPastContracts
            )

            HorizontalDivider()

        }
    }

}

@Composable
private fun ProfileHeader(
    imageUri: Uri? = null,
    onPhotoSelected: (Uri) -> Unit,
    name: String = "",
    numActiveContracts: Int = 0,
    numPastContracts: Int = 0

) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(28.dp)
    ){
        PhotoPicker(
            imageUri = imageUri,
            onPhotoSelected = onPhotoSelected
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)

            ){
                Text(
                    text = "Active Contracts: $numActiveContracts",
                    fontSize = 13.sp
                )
                Text(
                    text = "Past Contracts: $numPastContracts",
                    fontSize = 13.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        userName = "John Doe",
        money = 1000,
        numActiveContracts = 5,
        numPastContracts = 10
    )
}