package ingfabian.userpost.di

import dagger.Module
import dagger.Provides
import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.AddUser
import ingfabian.userpost.data.repository.UserRepositoryImpl

@Module
class UseCasesModule{

    @Provides
    fun provideAddUser (userRepository: UserRepositoryImpl): AddUser{
        return AddUser(userRepository)
    }
}