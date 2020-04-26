package ingfabian.userpost.presentation.ui.login.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ingfabian.userpost.databinding.FragmentHomeBinding
import ingfabian.userpost.presentation.ui.home.HomeActivity


class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
            ViewModelProviders.of(this).get(LoginViewModel::class.java)
       // val root = inflater.inflate(R.layout.fragment_home, container, false)

        val binding = FragmentHomeBinding.inflate(inflater,container, false)
        binding.loginViewModel = loginViewModel

        setObservable ()

        return binding.root
    }

    fun setObservable (){
        loginViewModel.userEntityObservable.observe(viewLifecycleOwner, Observer {
            if (it== null){
                Toast.makeText(this.context, "Problemas para acceder", Toast.LENGTH_LONG).show()
            }else {
                goToNewActivity()
            }
        })

        loginViewModel.respondPresentationObservable.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context, it, Toast.LENGTH_LONG).show()
        } )
    }

    fun goToNewActivity (){
        val intent = Intent (getActivity(), HomeActivity::class.java)
        getActivity()?.startActivity(intent)
    }
}