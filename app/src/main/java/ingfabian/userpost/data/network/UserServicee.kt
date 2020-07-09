package ingfabian.userpost.data.network

import ingfabian.core.models.JWToken
import ingfabian.userpost.BaseResponse
import retrofit2.Response
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface UserServicee {

    /*
    * @GET("sites/{SITE_ID}/search")
    suspend fun searchProduct(@Path("SITE_ID") side_id: String, @Query("q") q: String): ProductsRespond
    *
    * */
    //@Headers("Content-Type:application/json; charset=UTF-8")
    @FormUrlEncoded
    @POST("v1/users/create")
    suspend fun registerUser(
        @Field("displayName") displayName: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("userName") userName: String

    ): Response<BaseResponse<JWToken>>

    @GET("users")
    suspend fun getUsers(): List<UserNetwork>


}