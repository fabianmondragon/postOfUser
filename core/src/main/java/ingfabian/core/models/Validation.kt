package ingfabian.core.models

import ingfabian.core.usecases.entity.UserEntity

class Validation {

    fun validationPost (description: String) : Boolean  {
        return description.length> 200
    }

    private fun validationPost (user: UserEntity): Boolean{
        return user.age > 18
    }

    fun validateAgeAndTypePost (user: UserEntity, type: Int): Boolean{
        if (validationPost(user)){
            return true
        }
        return (!validationPost(user) && ((type == 3)))

    }








}