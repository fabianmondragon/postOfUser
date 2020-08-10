package ingfabian.userpost.presentation.ui.home

import android.os.Bundle
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import ingfabian.userpost.R
import ingfabian.userpost.presentation.ui.custom_views.CardPromotionalCoach
import ingfabian.userpost.presentation.ui.custom_views.CoachCardPresentation
import ingfabian.userpost.presentation.ui.custom_views.CoachPromotionalAdapter
import ingfabian.userpost.presentation.ui.custom_views.ViewHolderItem
import ingfabian.userpost.presentation.ui.login.login.LoginViewModel
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    lateinit var adapter: CoachPromotionalAdapter
    lateinit var viewPager2: ViewPager2
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewPager2 = findViewById(R.id.viewPagerPromotional)

        homeViewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]

        homeViewModel.loadPromotionalCoach()







        var listOfCoach = mutableListOf<ViewHolderItem>( CoachCardPresentation (1, "Fabian Mondragon", "Android", 4.5f),
            CoachCardPresentation (1, "Alejandro Mondragon", "iOS", 4.5f),
            CoachCardPresentation (1, "Jhonatan Ordoñes", "iONIC", 4.5f),
            CoachCardPresentation (1, "Robert Erazo", "Flutter", 4.5f),
            CoachCardPresentation (1, "Lady Saches", "Reac Native", 4.5f))

        adapter = CoachPromotionalAdapter(listOfCoach)
        viewPager2.adapter = adapter
        setConfigViewPager ()

    }

    fun setConfigViewPager(){

        with(viewPager2) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
        viewPager2.setPageTransformer { page, position ->
            val viewPager = page.parent.parent as ViewPager2
            val offset = position * -(2 * offsetPx + pageMarginPx)
            if (viewPager.orientation == ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }
        }
    }


}
