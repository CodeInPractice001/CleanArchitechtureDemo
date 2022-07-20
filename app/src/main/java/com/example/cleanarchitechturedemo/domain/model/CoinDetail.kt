package com.example.cleanarchitechturedemo.domain.model

import com.example.cleanarchitechturedemo.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId:String,
    val name:String,
    val description:String,
    val symbol:String,
    val rank:String,
    val isActive: Boolean,
    val tags:List<String>,
    val team:List<TeamMember>

)


