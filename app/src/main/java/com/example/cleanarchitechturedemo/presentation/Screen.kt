package com.example.cleanarchitechturedemo.presentation

sealed class Screen(val route:String){
    object CoinListScreen:Screen("CoinListScreen")
    object CoinDetailScreen:Screen("Coin_detail_Screen")
}