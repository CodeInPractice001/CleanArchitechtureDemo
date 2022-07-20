package com.example.cleanarchitechturedemo.domain.repository

import com.example.cleanarchitechturedemo.data.remote.dto.CoinDetailDto
import com.example.cleanarchitechturedemo.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinByID(coinId:String):CoinDetailDto
}