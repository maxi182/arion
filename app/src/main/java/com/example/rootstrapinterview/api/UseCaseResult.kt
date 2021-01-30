package com.example.rootstrapinterview.api

sealed class UseCaseResult<out T : Any, out U : Int> {
    class Success<out T : Any>(val data: T?) : UseCaseResult<T, Nothing>()
    class Failure<U : Int>(val error: U?) : UseCaseResult<Nothing, U>()
    class Exception(val exception: Throwable) : UseCaseResult<Nothing, Nothing>()
}