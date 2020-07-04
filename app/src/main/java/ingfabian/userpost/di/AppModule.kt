package ingfabian.userpost.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ingfabian.userpost.PostApplication


@Module
class AppModule  (val app: Application)
{

    @Provides
    fun providesApp () = app

    @Provides
    fun providesContext () = PostApplication.getContext()

}