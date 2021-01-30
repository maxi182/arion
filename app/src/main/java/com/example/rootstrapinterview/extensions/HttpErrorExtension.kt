package com.example.rootstrapinterview.extensions

import com.example.rootstrapinterview.R

fun Int.getHttpError(): Int {
    return when (this) {
        ErrorCodes.SocketTimeOut.code -> R.string.error_timeout
        401 -> R.string.error_401
        403 -> R.string.error_403
        404 -> R.string.error_404
        500 -> R.string.error_500
        502 -> R.string.error_502
        301 -> R.string.error_301
        302 ->R.string.error_302
        else -> R.string.error_generic
    }
}

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}
