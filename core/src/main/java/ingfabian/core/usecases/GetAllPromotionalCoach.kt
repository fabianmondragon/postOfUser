package ingfabian.core.usecases

import ingfabian.core.models.request.PromotionalCoachRequest
import ingfabian.core.repository.CoachRepository

class GetAllPromotionalCoach  (val repository: CoachRepository) {



    suspend fun getAllPromotionalCoach ( request: PromotionalCoachRequest)=
        repository.getPromotionalCoach(request)

}