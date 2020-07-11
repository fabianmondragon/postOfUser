package ingfabian.userpost.presentation.ui.login.registration

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import ingfabian.userpost.PostApplication
import ingfabian.userpost.R
import ingfabian.userpost.databinding.FragmentRegisterBinding
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.ui.login.login.LoginFragment
import ingfabian.userpost.presentation.ui.post.PostViewModel
import kotlinx.android.synthetic.main.fragment_register.view.*
import javax.inject.Inject


class RegistrationFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var registrationViewModel: RegistrationViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as PostApplication).appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registrationViewModel = ViewModelProviders.of(this, viewModelFactory)[RegistrationViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentRegisterBinding.inflate(inflater,container, false)
        binding.registrationViewMode = registrationViewModel
        setObserver()
        return binding.root

    }
    @SuppressLint("ResourceType")
    fun setObserver (){
        registrationViewModel.result.observe(viewLifecycleOwner, Observer {
             if (it.code == ConstantPresentation.RESULT_SUCCESS_TRANSACTION){
                 Toast.makeText(this.context, it.msg, Toast.LENGTH_LONG).show()
                transitionAnotherFragment()
             }
             else {
                 Toast.makeText(this.context, it.msg, Toast.LENGTH_LONG).show()
             }
         })

    }
    fun transitionAnotherFragment () {
        val navController = findNavController()
        navController.navigate( R.id.navigation_home)
    }



}
