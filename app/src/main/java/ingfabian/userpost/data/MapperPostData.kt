package ingfabian.userpost.data

import ingfabian.core.usecases.entity.PostEntity
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.data.frameworks.PostDB
import ingfabian.userpost.data.frameworks.UserDB

class MapperPostData {

    fun convertUserFromDomainToDB (userEntity: UserEntity): UserDB{
        return  UserDB (userName = userEntity.userName, firstName = userEntity.name,
            password = userEntity.password, age = userEntity.age)
    }

    fun convertPostFromDomainToDB (userId: Int, postEntity: PostEntity): PostDB{
        return  PostDB (postEntity.title, postEntity.description, userId)
    }


}