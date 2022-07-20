package com.example.cleanarchitechturedemo.presentation.coin_list

import com.example.cleanarchitechturedemo.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String =""
)
