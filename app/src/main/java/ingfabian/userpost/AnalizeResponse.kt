package ingfabian.userpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import ingfabian.core.Result
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.ui.login.model.RespondPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke


/*fun <T> resultLiveData (networkCall: suspend() -> Result<T>) : MutableLiveData<RespondPresentation>
= MutableLiveData

{
    val respond = networkCall.invoke()
    when (respond.invoke()) {
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


/*fun <T> resultLiveData(networkCall: suspend () -> Result<T>): LiveData<Result<T>> = liveData(
    Dispatchers.IO) {
    emit(Result.loading<T>())
    val responseStatus = networkCall.invoke()
    if (responseStatus.status == Result.Status.SUCCESS) {
        val resultResponse = responseStatus.data
        val live : LiveData<Any> = MutableLiveData(resultResponse)
        val map = live.map { Result.success(it)}
        emitSource(map)
    } else if (responseStatus.status == Result.Status.ERROR) {
        emit(Result.error<T>(responseStatus.message!!))
    }
}*/

/*
*
fun <T> resultLiveData(networkCall: suspend () -> Result<T>): LiveData<Result<T>> = liveData(Dispatchers.IO) {
    emit(Result.loading<T>())
    val responseStatus = networkCall.invoke()
    if (responseStatus.status == Result.Status.SUCCESS) {
        val resultResponse = responseStatus.data
        val live : LiveData<T> = MutableLiveData(resultResponse)
        val map = live.map { Result.success(it)}
        emitSource(map)
    } else if (responseStatus.status == Result.Status.ERROR) {
        emit(Result.error<T>(responseStatus.message!!))
    }
}
*
* */