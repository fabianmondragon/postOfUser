package ingfabian.userpost.presentation.ui.custom_views

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import ingfabian.userpost.R

class CardPromotionalCoach (context: Context) : ConstraintLayout(context) {
    private var root: View
    lateinit var viewPager2 :ViewPager2

    init{
        root = View.inflate(context, R.layout.card_promotional_coach_layout, this)
        viewPager2 = root.findViewById(R.id.carPromotionalCoach)
    }



}