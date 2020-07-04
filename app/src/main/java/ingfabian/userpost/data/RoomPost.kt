package ingfabian.userpost.data

import ingfabian.core.datasource.LocalDataSourcePost
import ingfabian.core.usecases.entity.PostEntity


class RoomPost  : LocalDataSourcePost {
    //val postDao = ingfabian.userpost.data.frameworks.DataBasePost.getInstance(context).postDBDAO()
    lateinit var  mapperPostData: ingfabian.userpost.data.MapperPostData


    override fun addPost(userId: Int, post: PostEntity): Long {
       /* mapperPostData = MapperPostData()
        val postDB = mapperPostData.convertPostFromDomainToDB(userId, post)
        return postDao.addPost(postDB)*/
        return 1
    }
    

    override fun getPostByUser(userId: Int): List<PostEntity>? {
       return null
        // return postDao.getPostByUser(userId)
    }




}