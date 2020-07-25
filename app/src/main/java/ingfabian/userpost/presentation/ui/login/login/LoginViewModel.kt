package ingfabian.userpost.presentation.ui.login.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ingfabian.core.Result
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.UserResponse
import ingfabian.core.usecases.Login
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.PostApplication
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.ui.login.model.UserPresentation
import ingfabian.userpost.presentation.ui.login.registration.JWTManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {

    val userPresent = UserPresentation()
    val userEntityObservable = MutableLiveData<UserEntity>()
    val respondPresentationObservable = MutableLiveData<String>()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val jwtManager: JWTManager = JWTManager()


    @Inject
    lateinit var login: Login

    init {
        (PostApplication.getContext().applicationContext as PostApplication).appComponent.inject(
            this
        )
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    fun login() {

        var userEntity = userPresent.userName.get()?.let { it ->
            userPresent.password.get()?.let { it1 ->
                UserEntity(userName = it, password = it1)
            }
        }
        coroutineScope.launch {
            userEntity?.let {
                val respond = login.login(it)

                when (respond.status) {
                    Result.Status.SUCCESS -> {
                        val baseResponse = respond.data as BaseResponse<UserResponse>
                        if (baseResponse.customCode == ConstantPresentation.RESULT_SUCCESS_TRANSACTION) {
                            jwtManager.saveJWT(
                                baseResponse.response!!.token,
                                baseResponse.response!!.userName
                            )
                            userEntityObservable.postValue(it)
                        }

                    }
                    Result.Status.ERROR -> respondPresentationObservable.postValue("Datos Incorrectos")
                }
            }
        }
    }
}