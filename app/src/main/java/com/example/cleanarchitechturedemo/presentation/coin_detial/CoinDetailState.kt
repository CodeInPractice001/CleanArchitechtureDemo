package com.example.cleanarchitechturedemo.presentation.coin_detial

import com.example.cleanarchitechturedemo.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin:CoinDetail ?=null,
    val error:String =""
)
