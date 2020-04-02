package ingfabian.core.usecases

import ingfabian.core.models.Validation
import ingfabian.core.repository.PostRepository
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.core.usecases.entity.UserEntity

class AddPost (val postRepository: PostRepository) {

    val validation= Validation ()

    suspend fun addPost (userEntity: UserEntity, post: PostEntity): Boolean{
       // if (!validation.validationPost(post.description)) return false
        //if (!validation.validateAgeAndTypePost(userEntity, post.type)) return false
        postRepository.addPost(1, post)
        return true
    }


}