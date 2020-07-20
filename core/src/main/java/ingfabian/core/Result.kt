package ingfabian.core

import ingfabian.core.models.BaseResponse


data class Result<T>(val status: Status, val data: Any?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: Any?): Result<T> {
            return Result(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(message: String, data: Any? = null): Result<T> {
            return Result(
                Status.ERROR,
                data,
                message
            )
        }

        fun <T> loading( data: Any? = null): Result<T> {
            return Result(
                Status.LOADING,
                data,
                null
            )
        }
    }
}