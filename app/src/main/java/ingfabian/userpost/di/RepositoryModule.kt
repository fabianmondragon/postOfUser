package ingfabian.userpost.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ingfabian.userpost.data.RoomUser
import ingfabian.userpost.data.network.UserApiHelper
import ingfabian.userpost.data.network.UserServicee
import ingfabian.userpost.data.repository.RemoteDataSourceImpl
import ingfabian.userpost.data.repository.UserRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    fun providesRepository (localDataSourceUser: RoomUser, remoteDataSource: RemoteDataSourceImpl)=
        UserRepositoryImpl(localDataSourceUser,remoteDataSource )


    @Provides
    fun providesRemoteDataSource (userApiHelper: UserApiHelper)= RemoteDataSourceImpl (userApiHelper)




    /*

    * @Provides
    fun provideAddUser (userRepository: UserRepositoryImpl): AddUser{
        return AddUser(userRepository)
    }
    * */
}