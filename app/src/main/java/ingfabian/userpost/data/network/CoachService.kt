package ingfabian.userpost.data.network

import ingfabian.core.models.BaseResponse
import ingfabian.core.models.PromotionalCoachResponse
import ingfabian.core.models.RegisterResponse
import ingfabian.core.models.UserResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface CoachService {

    @FormUrlEncoded
    @GET("v1/getPromotionalCoach")
    suspend fun getAllPromotionalCoach(
        @Field("language") language: String,
        @Field("tecnology") tecnology: String
    ): Response<BaseResponse<PromotionalCoachResponse>>


}