package ingfabian.core.usecases

import ingfabian.core.Result
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.JWToken
import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.entity.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.*



class AddUser(val userRepository: UserRepository) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    suspend fun addUser(userEntity: UserEntity) = userRepository.addUser(userEntity)



    /*Result<BaseResponse<JWToken>>? {
        coroutineScope.launch {
            val respond = userRepository.addUser(userEntity)
            when (respond.status) {
                Result.Status.SUCCESS ->
                    Result.Status.LOADING ->
                Result.Status.ERROR ->

            }

        }
        return null

    }*/


    /*
    *  coroutineScope.launch {
            val respond = addUser.addUser(
                userEntity = UserEntity(
                    userName = "mondra6",
                    password = "verylongpassword",
                    email = "tester6@gmail.com",
                    displayName = "Jhonny Testeer3"
                )
            )
            when (respond.status) {
                Result.Status.SUCCESS -> result.postValue(
                    RespondPresentation(
                        ConstantPresentation.LOGIN_TRANSACTION_MSG_SUCCESS,
                        ConstantPresentation.RESULT_SUCCESS_TRANSACTION,
                        ConstantPresentation.LOGIN_TRANSACTION
                    )
                )
                Result.Status.ERROR -> result.postValue(
                    RespondPresentation(
                        ConstantPresentation.LOGIN_TRANSACTION_MSG_ERROR,
                        ConstantPresentation.RESULT_SUCCESS_TRANSACTION,
                        ConstantPresentation.LOGIN_TRANSACTION
                    )
                )


            }


        }
    *
    * */


    /*var result = userRepository.addUser(userEntity)
     when (result.status) {
        Result.Status.SUCCESS -> return 0
        Result.Status.ERROR -> return 1
        else -> return 2
    }*/

    //}


}