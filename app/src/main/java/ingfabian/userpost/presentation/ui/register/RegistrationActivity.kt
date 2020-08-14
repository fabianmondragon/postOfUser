package ingfabian.userpost.presentation.ui.register

import android.os.Bundle
import com.example.customview.DataLoadStepperManager
import com.example.customview.StepperActivity

class RegistrationActivity : StepperActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setSteps(
            arrayListOf(
                BasicRegistrationFragment.newInstance("hola", "hola2"),
                BasicRegistrationFragment.newInstance("hola2", "hola2")
            ), DataLoadStepperManager.REGISTER
        )

        nextStep()

    }
}
