
package com.example.rootstrapinterview.api

import com.example.rootstrapinterview.extensions.ErrorCodes
import com.example.rootstrapinterview.extensions.getHttpError
import retrofit2.HttpException
import java.lang.Exception
import java.net.SocketTimeoutException


open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> Resource.error(e.code().getHttpError(), null)
            is SocketTimeoutException -> Resource.error(
                ErrorCodes.SocketTimeOut.code.getHttpError(), null
            )
            else -> Resource.error(Int.MAX_VALUE.getHttpError(), null)
        }
    }
}
