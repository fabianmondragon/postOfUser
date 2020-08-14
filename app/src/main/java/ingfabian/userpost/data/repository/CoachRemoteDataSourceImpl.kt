package ingfabian.userpost.data.repository

import ingfabian.core.Result
import ingfabian.core.datasource.CoachRemoteDataSource
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.PromotionalCoachResponse

class CoachRemoteDataSourceImpl : CoachRemoteDataSource {
    override suspend fun getPromotionalCoach(
        language: String,
        tecnology: String
    ): Result<BaseResponse<PromotionalCoachResponse>>? {
        return null

    }
}