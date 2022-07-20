package com.example.cleanarchitechturedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitechturedemo.presentation.Screen
import com.example.cleanarchitechturedemo.presentation.coin_detial.CoinDetailScreen
import com.example.cleanarchitechturedemo.presentation.coin_list.components.CoinListScreen
import com.example.cleanarchitechturedemo.ui.theme.CleanArchitechtureDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitechtureDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .padding(10.dp),
                    color = MaterialTheme.colors.background
                ) {
                 val navController = rememberNavController()
                   NavHost(navController = navController,
                       startDestination = Screen.CoinListScreen.route
                        ){
                       composable(route =Screen.CoinListScreen.route){
                           CoinListScreen(navController)
                       }
                       composable(route =Screen.CoinDetailScreen.route+"/{coinId}"){
                           CoinDetailScreen()
                       }
                   }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CleanArchitechtureDemoTheme {
        Greeting("Android")
    }
}