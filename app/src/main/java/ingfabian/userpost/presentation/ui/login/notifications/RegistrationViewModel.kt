package ingfabian.userpost.presentation.ui.login.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ingfabian.core.usecases.AddUser
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.data.RoomUser
import ingfabian.userpost.data.repository.UserRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel (application: Application) : AndroidViewModel(application) {


    lateinit var mutableUser : MutableLiveData<UserEntity>
    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    val addUser = AddUser (userRepository = UserRepositoryImpl(RoomUser(application)))
    private val coroutineScope = CoroutineScope(Dispatchers.IO)



    fun register (){
        coroutineScope.launch {
            mutableUser.value?.let { addUser.userRepository.addUser(it) }
        }
    }
}