package ingfabian.userpost.presentation.ui.login.registration

import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.getString
import ingfabian.core.models.JWToken
import ingfabian.userpost.PostApplication
import ingfabian.userpost.R
import ingfabian.userpost.presentation.ConstantPresentation

class JWTManager  {

    fun saveJWT (token: JWToken){
        val context = PostApplication.getContext().applicationContext
        val sharedPref = context.getSharedPreferences(
           context.getString(R.string.preference_file_key), Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(context.getString(R.string.jwt_token), token.token)
            putString (context.getString(R.string.jwt_userId), token.userId)
            commit()
        }
    }

    fun saveJWT (token: String, userName: String){
        val context = PostApplication.getContext().applicationContext
        val sharedPref = context.getSharedPreferences(
            context.getString(R.string.preference_file_key), Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(context.getString(R.string.jwt_token), token)
            putString (context.getString(R.string.jwt_userId), userName)
            commit()
        }
    }


}