package ingfabian.userpost.presentation.ui.login.registration

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ingfabian.core.repository.UserRepositoryImpl
import ingfabian.core.usecases.AddUser
import ingfabian.userpost.data.RoomUser
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.MapperPostPresentation
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

    val result = MutableLiveData<Long>()

    fun register (){

        if (userPresentation.validateEmptyField (userPresentation)) {
            coroutineScope.launch {
                val userEntity =
                    mapperPostPresentation.convertUserFromPresentationToDomain(userPresentation)
                val l = addUser.addUser(userEntity)
                result.postValue(l)
            }
        }else {
            Toast.makeText(getApplication(), ConstantPresentation.EMPTY_FIELD, Toast.LENGTH_LONG).show()
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