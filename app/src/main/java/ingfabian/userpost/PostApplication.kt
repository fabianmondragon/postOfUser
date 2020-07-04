package ingfabian.userpost

import android.app.Application
import android.content.Context
import ingfabian.userpost.di.DaggerApplicationComponent


class PostApplication: Application() {

    val appComponent = DaggerApplicationComponent.create()



    companion object {

        private lateinit var context: Context

        fun setContext(context: Context) {
            this.context=context
        }

        fun getContext () : Context{
            return this.context
        }
    }





}