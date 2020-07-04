package ingfabian.userpost.data.network

import ingfabian.core.models.JWToken
import ingfabian.userpost.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface UserServicee {

    @GET("users")
    suspend fun registerUser(userEntity: UserNetwork): Response<BaseResponse<JWToken>>

    @GET("users")
    suspend fun getUsers(): List<UserNetwork>


}