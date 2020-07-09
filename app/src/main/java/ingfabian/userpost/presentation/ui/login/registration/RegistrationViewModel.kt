package ingfabian.userpost.presentation.ui.login.registration

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ingfabian.core.Result
import ingfabian.core.usecases.AddUser
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.PostApplication
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.MapperPostPresentation
import ingfabian.userpost.presentation.ui.login.model.RespondPresentation
import ingfabian.userpost.presentation.ui.login.model.UserPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var addUser: AddUser
    lateinit var context: Context
    var userPresentation = UserPresentation()
    val mapperPostPresentation = MapperPostPresentation()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val result = MutableLiveData<RespondPresentation>()

    init {
        (PostApplication.getContext().applicationContext as PostApplication).appComponent.inject(
            this
        )
    }

    fun register() {

        coroutineScope.launch {
            val respond = addUser.addUser(
                userEntity = UserEntity(
                    userName = "mondra6",
                    password = "verylongpassword",
                    email = "tester6@gmail.com",
                    displayName = "Jhonny Testeer3"
                )
            )
            when (respond.status) {
                Result.Status.SUCCESS -> result.postValue(
                    RespondPresentation(
                        ConstantPresentation.LOGIN_TRANSACTION_MSG_SUCCESS,
                        ConstantPresentation.RESULT_SUCCESS_TRANSACTION,
                        ConstantPresentation.LOGIN_TRANSACTION
                    )
                )
                Result.Status.ERROR -> result.postValue(
                    RespondPresentation(
                        ConstantPresentation.LOGIN_TRANSACTION_MSG_ERROR,
                        ConstantPresentation.RESULT_SUCCESS_TRANSACTION,
                        ConstantPresentation.LOGIN_TRANSACTION
                    )
                )


            }


        }


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


    fun onNameTextChange(s: CharSequence, start: Int, before: Int, count: Int) {
        if (count == 0)
            userPresentation.nameError.set(ConstantPresentation.EMPTY_FIELD)
    }

    fun onPasswordChange(s: CharSequence, start: Int, before: Int, count: Int) {
        if (s.length > 3) {
            userPresentation.validatePassword(s, userPresentation)
        }
    }

    fun onPasswordAgainChange(s: CharSequence, start: Int, before: Int, count: Int) {
        if (s.length > 3) {
            userPresentation.validatePasswordAgain(s, userPresentation)
        }
    }


}