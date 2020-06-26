package ingfabian.userpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import ingfabian.core.Result
import kotlinx.coroutines.Dispatchers

fun <T> resultLiveData(networkCall: suspend () -> Result<T>): LiveData<Result<T>> = liveData(
    Dispatchers.IO) {
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