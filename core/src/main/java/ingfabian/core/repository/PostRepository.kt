package ingfabian.core.repository

import ingfabian.core.usecases.entity.PostEntity

interface
PostRepository {
    suspend fun getPostByUser (userId: Int) : List<PostEntity>

    suspend fun addPost ( userId:Int, post: PostEntity): Boolean
}