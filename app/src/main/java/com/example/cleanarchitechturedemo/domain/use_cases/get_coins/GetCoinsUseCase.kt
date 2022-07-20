package com.example.cleanarchitechturedemo.domain.use_cases.get_coins

import com.example.cleanarchitechturedemo.common.Resource
import com.example.cleanarchitechturedemo.data.remote.dto.toCoin
import com.example.cleanarchitechturedemo.domain.model.Coin
import com.example.cleanarchitechturedemo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> =
        flow {
            try {
                emit(Resource.Loading())
                val coins = repository.getCoins().map { it.toCoin() }
                emit(Resource.Success(coins))
            } catch (e: IOException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: HttpException) {
                emit(Resource.Error("Check Internet"))
            }
        }
}