package com.example.cleanarchitechturedemo.domain.use_cases.get_coin

import com.example.cleanarchitechturedemo.common.Resource
import com.example.cleanarchitechturedemo.data.remote.dto.toCoinDetail
import com.example.cleanarchitechturedemo.domain.model.CoinDetail
import com.example.cleanarchitechturedemo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {

            emit(Resource.Loading())
            val coin = repository.getCoinByID(coinId)
            emit(Resource.Success(coin.toCoinDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "an unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(e.toString()))
        }
    }
}