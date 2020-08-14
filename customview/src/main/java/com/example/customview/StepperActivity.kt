package com.example.customview

import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class StepperActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var listFragment: ArrayList<Fragment>
    lateinit var stepperFragmentInfo: StepperFragmentInfo
    lateinit var btnNext: Button
    private var position: Int = 0
    var moveSum: Int = 0
    private lateinit var progressBarAnimation: ProgressBarAnimation
    private lateinit var dataLoadStepperManager: DataLoadStepperManager

    lateinit var texViewStep: TextView
    lateinit var textViewDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stepper)
        position = 0
        moveSum = 0
        bindView()
        dataLoadStepperManager = DataLoadStepperManager(this)
    }

    fun bindView() {
        progressBar = findViewById(R.id.progress_horizontal)
        progressBarAnimation = ProgressBarAnimation(progressBar)
        progressBarAnimation.to = 0f
        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            nextStep()
        }
        texViewStep = findViewById(R.id.textViewNumberStep)
        textViewDescription = findViewById(R.id.textViewNameStep)
    }

    fun setBackgroundColor(resource: Int) {
        progressBar.setBackgroundColor(resource)
    }

    fun nextStep() {
        val tempFragment = stepperFragmentInfo.itemFragment[position]
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contentLayout, tempFragment)
        transaction.addToBackStack(null)
        transaction.commit()
        progressBarAnimation.to = progressBarAnimation.to + moveSum
        progressBar.startAnimation(progressBarAnimation)
        texViewStep.text = stepperFragmentInfo.stepList[position].toString()
        textViewDescription.text = stepperFragmentInfo.description[position]
        position += 1
    }

    fun setSteps(listFragment: ArrayList<Fragment>, type: String) {
        this.listFragment = listFragment
        var optionsDescription = dataLoadStepperManager.loadData(type)
        var steps = ArrayList<Int>()

        for (i in 0..listFragment.size) {
            steps.add(i)
        }
        stepperFragmentInfo = StepperFragmentInfo(listFragment, optionsDescription, steps)
        moveSum = 100 / stepperFragmentInfo.itemFragment.size
    }


    private fun setMaxProgressBar(numItem: Int) {
        progressBarAnimation.to = 0f
    }

    class ProgressBarAnimation internal constructor(private val progressBar: ProgressBar) :
        Animation() {
        var to: Float = 0f
        private val progressBarAnimationDuration = 700L

        init {
            duration = progressBarAnimationDuration
            interpolator = AccelerateDecelerateInterpolator()
        }

        override fun applyTransformation(interpolatedTime: Float, transformation: Transformation) {
            super.applyTransformation(interpolatedTime, transformation)
            val value = progressBar.progress + (to - progressBar.progress) * interpolatedTime
            progressBar.progress = value.toInt() + 1
        }
    }


}
