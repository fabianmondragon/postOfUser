package ingfabian.userpost.presentation.ui.login.registration

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ingfabian.userpost.R
import ingfabian.userpost.databinding.FragmentRegisterBinding
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.ui.login.login.LoginFragment


class RegistrationFragment : Fragment() {

    private lateinit var registrationViewModel: RegistrationViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registrationViewModel =
            ViewModelProviders.of(this)[RegistrationViewModel::class.java]
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
                val newFragment = LoginFragment()
                val transaction = fragmentManager?.beginTransaction()?.apply {

                    replace(R.id.nav_host_fragment, newFragment)
                    addToBackStack(null)
                }
                transaction?.commit()
            }
            else {
                Toast.makeText(this.context, it.msg, Toast.LENGTH_LONG).show()
            }
        })

    }

}
