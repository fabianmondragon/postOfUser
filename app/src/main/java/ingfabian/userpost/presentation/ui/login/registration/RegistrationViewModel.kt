package ingfabian.userpost.presentation.ui.login.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ingfabian.core.repository.UserRepositoryImpl
import ingfabian.core.usecases.AddUser
import ingfabian.userpost.data.RoomUser
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.MapperPostPresentation
import ingfabian.userpost.presentation.ui.login.model.RespondPresentation
import ingfabian.userpost.presentation.ui.login.model.UserPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel (application: Application) : AndroidViewModel(application) {

    var userPresentation = UserPresentation()
    val mapperPostPresentation = MapperPostPresentation()
    val addUser = AddUser (userRepository = UserRepositoryImpl(
        RoomUser(application)
        )
    )
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val result = MutableLiveData<RespondPresentation>()

    fun register (){


        if (userPresentation.validateEmptyField (userPresentation)) {
            coroutineScope.launch {
                val userEntity =
                    mapperPostPresentation.convertUserFromPresentationToDomain(userPresentation)
                val l = addUser.addUser(userEntity)
                if (l != -1L ){
                    result.postValue(RespondPresentation(ConstantPresentation.LOGIN_TRANSACTION_MSG_SUCCESS, ConstantPresentation.RESULT_SUCCESS_TRANSACTION,ConstantPresentation.LOGIN_TRANSACTION))
                } else {
                    result.postValue(RespondPresentation(ConstantPresentation.LOGIN_TRANSACTION_MSG_ERROR, ConstantPresentation.RESULT_SUCCESS_TRANSACTION,ConstantPresentation.LOGIN_TRANSACTION))
                }

            }
        }
        else {

        }
    }

    fun onNameTextChange (s: CharSequence,start: Int,before : Int, count :Int){
        if (count==0)
            userPresentation.nameError.set(ConstantPresentation.EMPTY_FIELD)
    }

    fun onPasswordChange (s: CharSequence,start: Int,before : Int, count :Int){
        if (s.length > 3){
            userPresentation.validatePassword(s, userPresentation)
        }
    }

    fun onPasswordAgainChange (s: CharSequence,start: Int,before : Int, count :Int){
        if (s.length>3) {
            userPresentation.validatePasswordAgain(s, userPresentation)
        }
    }



}