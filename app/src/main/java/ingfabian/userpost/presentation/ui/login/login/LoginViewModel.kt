package ingfabian.userpost.presentation.ui.login.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ingfabian.core.usecases.entity.UserEntity
import com.example.data.RoomUser
import ingfabian.userpost.presentation.ui.login.model.UserPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val userPresent = UserPresentation()
    /*val login = Login(
        userRepository = UserRepositoryImpl(
            RoomUser(application), RemoteDataSourceImpl( UserApiHelper(()))
        )
    )*/
    val userEntityObservable = MutableLiveData<UserEntity>()
    val respondPresentationObservable = MutableLiveData<String>()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    fun login() {


        var userEntity = userPresent.userName.get()?.let { it ->
            userPresent.password.get()?.let { it1 ->
//                    UserEntity(userName = it, password = it1, name = "")

            }
        }
        coroutineScope.launch {
            userEntity?.let {

                /*val userP = login.login(it)
                userP.let {
                    userEntityObservable.postValue(it)
                }
                respondPresentationObservable.postValue("Datos Incorrectos")*/

            }
        }
    }
}