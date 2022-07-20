package com.example.cleanarchitechturedemo.data.repository

import com.example.cleanarchitechturedemo.data.remote.CoinPaprikaApi
import com.example.cleanarchitechturedemo.data.remote.dto.CoinDetailDto
import com.example.cleanarchitechturedemo.data.remote.dto.CoinDto
import com.example.cleanarchitechturedemo.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }


    override suspend fun getCoinByID(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }


}