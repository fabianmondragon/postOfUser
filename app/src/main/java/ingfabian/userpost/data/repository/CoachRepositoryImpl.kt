package ingfabian.userpost.data.repository

import ingfabian.core.datasource.CoachRemoteDataSource
import ingfabian.core.models.request.PromotionalCoachRequest
import ingfabian.core.repository.CoachRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoachRepositoryImpl(val coachDataSource: CoachRemoteDataSource ) :
    CoachRepository {

    override suspend fun getPromotionalCoach(promotionalCoachRequest: PromotionalCoachRequest) =
        withContext(Dispatchers.IO) {
            return@withContext coachDataSource.getPromotionalCoach(promotionalCoachRequest.language,
            promotionalCoachRequest.tecnology)
        }
}


