package ingfabian.userpost.presentation.ui.home

import androidx.lifecycle.ViewModel
import ingfabian.core.Result
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.UserResponse
import ingfabian.core.models.request.PromotionalCoachRequest
import ingfabian.core.usecases.GetAllPromotionalCoach
import ingfabian.userpost.presentation.ConstantPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    /*val getAllPromotionalCoach = GetAllPromotionalCoach()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun loadPromotionalCoach() {
        coroutineScope.launch {
            val respond = getAllPromotionalCoach.getAllPromotionalCoach(PromotionalCoachRequest("kotlin","android" ))
            when (respond.status) {
                Result.Status.SUCCESS -> {
                }
                Result.Status.ERROR -> {

                }
            }

        }




    }*/
}