package ingfabian.userpost.presentation.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import ingfabian.userpost.PostApplication
import ingfabian.userpost.R
import ingfabian.userpost.presentation.ui.post.PostViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {


    //lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        //val vm = ViewModelProviders.of(this, viewModelFactory)[PostViewModel::class.java]
        setContentView(R.layout.activity_login)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,  R.id.navigation_register, R.id.navigation_password
            )
        )


        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Fabian")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle )


        PostApplication.setContext(this);
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
