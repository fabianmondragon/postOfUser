package ingfabian.core.datasource

import ingfabian.core.usecases.entity.PostEntity



interface LocalDataSourcePost {

    fun getPostByUser (userId: Int) : List<PostEntity>?
    fun addPost ( userId: Int, post: PostEntity): Long

}