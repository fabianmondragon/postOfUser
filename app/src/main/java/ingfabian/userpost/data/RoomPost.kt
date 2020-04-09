package ingfabian.userpost.data

import android.content.Context
import ingfabian.core.datasource.LocalDataSourcePost
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.userpost.data.frameworks.DataBasePost

class RoomPost (context: Context) : LocalDataSourcePost {
    val postDao = DataBasePost.getInstance(context).postDBDAO()
    lateinit var  mapperPostData: MapperPostData


    override fun addPost(userId: Int, post: PostEntity): Long {
        mapperPostData = MapperPostData()
        val postDB = mapperPostData.convertPostFromDomainToDB(userId, post)
        return postDao.addPost(postDB)
    }
    

    override fun getPostByUser(userId: Int): List<PostEntity>? {
       return null
        // return postDao.getPostByUser(userId)
    }




}