package ingfabian.userpost.presentation.ui.post

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ingfabian.core.repository.PostRepositoryImpl
import ingfabian.core.usecases.AddPost
import ingfabian.core.usecases.GetAllPost
import ingfabian.core.usecases.entity.PostEntity
import com.example.data.RoomPost
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.Validations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class PostViewModel (application: Application) : AndroidViewModel (application) {


    var listPost = MutableLiveData<List<PostEntity>>()
    var goToView = MutableLiveData<Int>()

    val post =  AddPost (postRepository = PostRepositoryImpl(
        com.example.data.RoomPost(application)
    )
    )
    val getAllUsesCase = GetAllPost (postRepository = PostRepositoryImpl(
        com.example.data.RoomPost(application)
    )
    )
    val validations= Validations()
    val editTextDescription = MutableLiveData<String> ()
    val editTextTitle = MutableLiveData<String> ()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)



    fun addPostByUser() {
//        val description = editTextDescription.value.toString()
//        val title = editTextTitle.value.toString()
//        if (validations.validateFielsdPost (title, description)){
//            val postEntity = PostEntity(title, description, 1)
//            val user = UserEntity(1, "Fabian", "mondra", 32, "gate")
//            coroutineScope.launch {
//                post.addPost(user, postEntity )
//            }
//        }
    }

    fun getAllUserPost() {
       /* val user = UserEntity(1, "Fabian", "mondra", 32, "gate")
        coroutineScope.launch {
            var list = getAllUsesCase.getPostByUser (user)
            listPost.postValue(list)
        }*/

    }


    //CharSequence s, int start, int before, int count)
    fun validateLimitCharacters (s: CharSequence, start: Int, before: Int, count: Int){


    }

    fun addPostView () {
        goToView.postValue(ConstantPresentation.GO_TO_ADD_POST)

    }


}