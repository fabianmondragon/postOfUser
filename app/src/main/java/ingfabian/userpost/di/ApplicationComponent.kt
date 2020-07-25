package ingfabian.userpost.di

import dagger.Component
import ingfabian.userpost.presentation.MainActivity
import ingfabian.userpost.presentation.ui.login.LoginActivity
import ingfabian.userpost.presentation.ui.login.login.LoginFragment
import ingfabian.userpost.presentation.ui.login.login.LoginViewModel
import ingfabian.userpost.presentation.ui.login.registration.RegistrationFragment
import ingfabian.userpost.presentation.ui.login.registration.RegistrationViewModel

@Component  (modules = [ViewModelModule::class, UseCasesModule::class, RepositoryModule::class, RetrofitModule::class])
interface ApplicationComponent {
    fun inject (registrationFragment: RegistrationFragment)
    fun inject (registrationViewModel: RegistrationViewModel)
    fun inject (loginViewModel: LoginViewModel)
    fun inject (loginFragment: LoginFragment)

}