package ingfabian.userpost.data

import android.content.Context
import ingfabian.userpost.data.datasource.LocalDataSourcePost
import ingfabian.userpost.data.frameworks.DataBasePost
import ingfabian.userpost.data.frameworks.PostDB

class RoomPost (context: Context) : LocalDataSourcePost {
    val postDao = DataBasePost.getInstance(context).postDBDAO()
    override fun addPost(post: PostDB): Boolean {
        val id =  postDao.addPost (post)
        return true
    }



    override fun getPostByUser(userId: Int): List<PostDB> {
        return postDao.getPostByUser(userId)
    }




}