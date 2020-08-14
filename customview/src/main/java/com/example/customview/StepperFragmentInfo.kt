package com.example.customview

import androidx.fragment.app.Fragment

data class StepperFragmentInfo(
    var itemFragment: ArrayList<Fragment>, val description: Array<out String>,
    val stepList: ArrayList<Int>)
