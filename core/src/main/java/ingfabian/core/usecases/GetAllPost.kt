package ingfabian.core.usecases

import ingfabian.core.repository.PostRepository
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.core.usecases.entity.UserEntity

class GetAllPost (val postRepository: PostRepository) {

    suspend fun getPostByUser (userEntity: UserEntity): List<PostEntity>? {
        if (userEntity.age > 18 ){
            return postRepository.getPostByUser (1)
        }
        return null
    }






}