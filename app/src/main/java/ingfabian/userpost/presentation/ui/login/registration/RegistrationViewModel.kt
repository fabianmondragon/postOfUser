package ingfabian.userpost.presentation.ui.login.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ingfabian.userpost.repository.UserRepositoryImpl
import ingfabian.core.usecases.AddUser
import ingfabian.core.usecases.entity.UserEntity
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
    val addUser = AddUser(UserRepositoryImpl())
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val result = MutableLiveData<RespondPresentation>()

    fun register (){
     
        coroutineScope.launch {
            addUser.addUser(userEntity = UserEntity(name="usuario", userName = "mondra10", password = "123", email = "mondra10@gmail.com" ))
        }

       /* coroutineScope.launch {
            val userEntity =
                mapperPostPresentation.convertUserFromPresentationToDomain(userPresentation)
            val l = addUser.addUser(userEntity)
            if (l != -1L ){
                result.postValue(RespondPresentation(ConstantPresentation.LOGIN_TRANSACTION_MSG_SUCCESS, ConstantPresentation.RESULT_SUCCESS_TRANSACTION,ConstantPresentation.LOGIN_TRANSACTION))
            } else {
                result.postValue(RespondPresentation(ConstantPresentation.LOGIN_TRANSACTION_MSG_ERROR, ConstantPresentation.RESULT_SUCCESS_TRANSACTION,ConstantPresentation.LOGIN_TRANSACTION))
            }

        }*/



        /*if (userPresentation.validateEmptyField( userPresentation)) {
                emit(Resource.loading(data = null))
                try {
                    val userEntity =
                        mapperPostPresentation.convertUserFromPresentationToDomain(userPresentation)
                    emit(Resource.success(data = addUser.addUser(userEntity)))
                } catch (exception: Exception) {
                    emit(
                        Resource.error(
                            data = null,
                            message = exception.message ?: "Error Occurred!"
                        )
                    )
                }
            }*/

        /*if (userPresentation.validateEmptyField (userPresentation)) {



            /*
            coroutineScope.launch {
                val userEntity =
                    mapperPostPresentation.convertUserFromPresentationToDomain(userPresentation)
                val l = addUser.addUser(userEntity)
                if (l != -1L ){
                    result.postValue(RespondPresentation(ConstantPresentation.LOGIN_TRANSACTION_MSG_SUCCESS, ConstantPresentation.RESULT_SUCCESS_TRANSACTION,ConstantPresentation.LOGIN_TRANSACTION))
                } else {
                    result.postValue(RespondPresentation(ConstantPresentation.LOGIN_TRANSACTION_MSG_ERROR, ConstantPresentation.RESULT_SUCCESS_TRANSACTION,ConstantPresentation.LOGIN_TRANSACTION))
                }

            }*/
        }
        else {

        }*/
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