package com.example.cleanarchitechturedemo.common

sealed class Resource<T>(
    val data:T ?= null,
    val msg :String? =null
){
    class Success<T>(data: T?):Resource<T>(data)
    class Error<T>(msg: String?, data: T?= null):Resource<T>(data= data,msg = msg)
    class Loading<T>(data: T? = null):Resource<T>(data)
}
