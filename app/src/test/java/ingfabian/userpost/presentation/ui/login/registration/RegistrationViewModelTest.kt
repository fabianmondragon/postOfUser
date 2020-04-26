package ingfabian.userpost.presentation.ui.login.registration

import ingfabian.userpost.presentation.ui.login.model.UserPresentation
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner




@RunWith(RobolectricTestRunner::class)
class RegistrationViewModelTest {

    var userPresentation = UserPresentation()
    lateinit var registrationViewModel : RegistrationViewModel

    lateinit var registerFragment: RegistrationFragment


    @Before
    fun config (){


    }

    @Test
    fun validateEmptyField_WithCorrectData_Success (){
        //Arrange
        userPresentation.name.set("Fabian")
        userPresentation.password.set ("Gate0quiet#")
        userPresentation.passwordAgain.set("Gate0quiet#")
        userPresentation.age.set(25)
        userPresentation.userName.set("mondra")
        //Act
        val result = userPresentation.validateEmptyField(userPresentation)
        //Assert
        assertTrue(result)
    }

    @Test
    fun validateEmptyField_WithParamNameEmpty_Fail (){
        //Arrange
        userPresentation.name.set("")
        userPresentation.password.set ("Gate0quiet#")
        userPresentation.passwordAgain.set("Gate0quiet#")
        userPresentation.age.set(25)
        userPresentation.userName.set("mondra")
        //Act
        val result = userPresentation.validateEmptyField(userPresentation)
        //Assert
        assertFalse(result)
    }

    @Test
    fun validateEmptyField_WithParamPasswordEmpty_Fail (){
        //Arrange
        userPresentation.name.set("Fabian")
        userPresentation.password.set ("")
        userPresentation.passwordAgain.set("Gate0quiet#")
        userPresentation.age.set(25)
        userPresentation.userName.set("mondra")
        //Act
        val result = userPresentation.validateEmptyField(userPresentation)
        //Assert
        assertFalse(
            result)
    }


}