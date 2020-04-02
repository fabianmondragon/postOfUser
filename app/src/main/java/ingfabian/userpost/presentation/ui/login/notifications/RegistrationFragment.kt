package ingfabian.userpost.presentation.ui.login.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ingfabian.userpost.databinding.FragmentRegisterBinding


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
        return binding.root
    }

}