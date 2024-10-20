package com.appdev.all_in_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.appdev.all_in_android.ui.components.general.AllInTopBar
import com.appdev.all_in_android.ui.theme.AllinandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AllinandroidTheme {
                Scaffold(
                    topBar = { AllInTopBar(title = "Home", money = 1000) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AllinandroidTheme {
        Scaffold(
            topBar = { AllInTopBar(title = "Home", money = 1000) },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Text(
                text = "Hello, World!",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
