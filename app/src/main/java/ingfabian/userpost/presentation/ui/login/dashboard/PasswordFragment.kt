package ingfabian.userpost.presentation.ui.login.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ingfabian.userpost.R

class PasswordFragment : Fragment() {

    private lateinit var passwordViewModel: PasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        passwordViewModel =
            ViewModelProviders.of(this).get(PasswordViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_password, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        passwordViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}