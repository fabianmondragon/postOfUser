package ingfabian.userpost.network

import ingfabian.core.Result
import ingfabian.core.models.JWToken
import ingfabian.userpost.BaseResponse
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult( call: suspend () -> Response<BaseResponse<T>>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body.results)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        return Result.error("Network call has failed for a following reason: $message")
    }

}

