package com.example.cleanarchitechturedemo.presentation.coin_detial

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitechturedemo.common.Constants
import com.example.cleanarchitechturedemo.common.Resource
import com.example.cleanarchitechturedemo.domain.use_cases.get_coin.GetCoinUseCase
import com.example.cleanarchitechturedemo.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
     savedStateHandle: SavedStateHandle //to pass the parameterize function in the init block
): ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state :State<CoinDetailState> = _state

    init{
        savedStateHandle.get<String>(Constants.KEY_COIN_ID)?.let { coinId->
            getCoin(coinId)
        }
    }
    private fun getCoin(coinId:String){
        getCoinUseCase(coinId).onEach { result->
            when(result){
                is Resource.Success->{_state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error->{
                    _state.value = CoinDetailState(error = result.msg ?: " an Unexpected error occured")
                }
                is Resource.Loading->{ _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}