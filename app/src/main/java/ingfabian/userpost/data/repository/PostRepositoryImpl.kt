package ingfabian.userpost.data.repository

import ingfabian.core.repository.PostRepository
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.userpost.data.MapperPost
import ingfabian.userpost.data.datasource.LocalDataSourcePost

class PostRepositoryImpl (val localDataSoucePost: LocalDataSourcePost) : PostRepository {

    private var mapperPost: MapperPost

    init {
        mapperPost = MapperPost()
    }

    override suspend fun getPostByUser(userId: Int): List<PostEntity> {
        val listPostDB = localDataSoucePost.getPostByUser(userId)
        return mapperPost.fromListDBtoListDomainPost(listPostDB)
    }

    override suspend fun addPost(userId: Int, post: PostEntity): Boolean {
        val postDB = mapperPost.fromDomaintoEntityPost(post)
        return localDataSoucePost.addPost( postDB)
    }
}