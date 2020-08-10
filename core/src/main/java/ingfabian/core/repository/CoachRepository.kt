package ingfabian.core.repository

import ingfabian.core.Result
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.PromotionalCoachResponse
import ingfabian.core.models.request.PromotionalCoachRequest
import ingfabian.core.usecases.entity.CoachEntity

interface CoachRepository {

    suspend fun getPromotionalCoach (promotionalCoachRequest: PromotionalCoachRequest): Result<BaseResponse<PromotionalCoachResponse>>
}
