package ingfabian.core.datasource

import ingfabian.core.Result
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.PromotionalCoachResponse

interface CoachRemoteDataSource {

    suspend fun getPromotionalCoach (language:String, tecnology: String): Result<BaseResponse<PromotionalCoachResponse>>
}