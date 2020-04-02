package ingfabian.userpost.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import ingfabian.userpost.R
import ingfabian.userpost.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        postViewModel = ViewModelProviders.of(this)[PostViewModel::class.java]
        binding.postViewModel = postViewModel




    }
}
