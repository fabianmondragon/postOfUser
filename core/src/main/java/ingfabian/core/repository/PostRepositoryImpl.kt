package ingfabian.core.repository

import ingfabian.core.datasource.LocalDataSourcePost
import ingfabian.core.usecases.entity.PostEntity

class PostRepositoryImpl (val localDataSoucePost: LocalDataSourcePost) : PostRepository {



    override suspend fun getPostByUser(userId: Int): List<PostEntity>? {
        return null
    }

    override suspend fun addPost(userId: Int, post: PostEntity): Long {
        return localDataSoucePost.addPost( userId, post)
    }
}