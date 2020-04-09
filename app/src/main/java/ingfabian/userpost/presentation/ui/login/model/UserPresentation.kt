package ingfabian.userpost.presentation.ui.login.model

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import ingfabian.userpost.presentation.ConstantPresentation

class UserPresentation {


    var passwordError = ObservableField<String>()
    var passwordAgainError = ObservableField<String>()
    var userNameError = ObservableField<String> ()
    var nameError = ObservableField<String>()
    var ageError = ObservableField<String>()

    val name = ObservableField<String>()
    val userName = ObservableField<String>()
    val age = ObservableInt()
    val password = ObservableField<String>()
    val passwordAgain = ObservableField<String> ()

    fun validateField (userPresentation: UserPresentation){

        if (userPresentation.name.get().equals("")){

        }

    }

    fun validatePassword (s: CharSequence, userPresentation: UserPresentation){
        val regex = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$")
        s?.let {
            if (!regex.matches(it))
                userPresentation.passwordError.set(ConstantPresentation.PASSWORD_ERROR)
            else {
                userPresentation.passwordError.set(null)
            }
        }
    }

    fun validatePasswordAgain (s: CharSequence, userPresentation: UserPresentation){

        if (!userPresentation.password.get()!!.equals(s.toString()))
        {
            userPresentation.passwordAgainError.set(ConstantPresentation.PASSWORD_AGAIN_ERROR)
        }else{
            userPresentation.passwordAgainError.set(null)
        }
    }

    fun validateEmptyField(userPresentation: UserPresentation): Boolean {
        userPresentation.age.set(34)
        if (userPresentation.name.get().equals("")|| (userPresentation.name.get() == null)){
            userPresentation.nameError.set(ConstantPresentation.EMPTY_FIELD)
            return false
        } else {
            userPresentation.nameError.set(null)
        }

        if (userPresentation.userName.get().equals("")|| (userPresentation.userName.get()== null)){
            userPresentation.userNameError.set(ConstantPresentation.EMPTY_FIELD)
            return false
        } else {
            userPresentation.userNameError.set(null)
        }

        if (userPresentation.age.get() == 0||(userPresentation.age.get() == null)){
            userPresentation.ageError.set(ConstantPresentation.EMPTY_FIELD)
            return false
        } else {
            userPresentation.ageError.set(null)
        }

        if (userPresentation.password.get().equals("")||(userPresentation.password.get()== null)){
            userPresentation.passwordError.set(ConstantPresentation.EMPTY_FIELD)
            return false
        } else {
            userPresentation.passwordError.set(null)
        }

        if (userPresentation.passwordAgain.get().equals("")|| (userPresentation.passwordAgain.get()==null)){
            userPresentation.passwordAgainError.set(ConstantPresentation.EMPTY_FIELD)
            return false
        } else {
            userPresentation.passwordAgainError.set(null)
        }
        return true
    }
}