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
import androidx.lifecycle.lifecycleScope
import com.appdev.all_in_android.ui.components.general.AllInTopBar
import com.appdev.all_in_android.ui.navigation.NavigationSetup
import com.appdev.all_in_android.ui.screens.CartScreen
import com.appdev.all_in_android.ui.theme.AllinandroidTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //testing networking
        lifecycleScope.launch {
//            val postApi = PostApi.instance
//            println("hello")
//            postApi.getAllContracts().body()?.forEach { println(it.id) }
//            postApi.getAllUsers().body()?.forEach { println(it.id) }
//            postApi.getAllTransactions().body()?.forEach { println(it.transactionDate) }
//            postApi.getAllPlayers().body()?.forEach { println(it.lastName) }

//            val playerRepository = PlayerRepository(PostApi.instance)
//            playerRepository.getAllPlayers().forEach{println(it.lastName)}
        }

        enableEdgeToEdge()
        setContent {

            AllinandroidTheme {
                NavigationSetup()

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
