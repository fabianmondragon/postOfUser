package ingfabian.userpost.presentation

import android.R.id
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import ingfabian.userpost.R
import ingfabian.userpost.databinding.ActivityMainBinding
import ingfabian.userpost.presentation.ui.post.PostViewModel
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var postViewModel: PostViewModel

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        postViewModel = ViewModelProviders.of(this)[PostViewModel::class.java]
        binding.postViewModel = postViewModel

    }


}
