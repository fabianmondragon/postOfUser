package com.example.data

import ingfabian.core.datasource.LocalDataSourcePost
import ingfabian.core.usecases.entity.PostEntity


class RoomPost  : LocalDataSourcePost {
    //val postDao = com.example.data.frameworks.DataBasePost.getInstance(context).postDBDAO()
    lateinit var  mapperPostData: com.example.data.MapperPostData


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