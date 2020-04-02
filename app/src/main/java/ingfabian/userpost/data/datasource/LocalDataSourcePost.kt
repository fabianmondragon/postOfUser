package ingfabian.userpost.data.datasource

import ingfabian.userpost.data.frameworks.PostDB


interface LocalDataSourcePost {

    fun getPostByUser (userId: Int) : List<PostDB>
    fun addPost ( post: PostDB): Boolean

}