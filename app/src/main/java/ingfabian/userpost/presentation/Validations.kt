package ingfabian.userpost.presentation

class Validations {

    fun validateFielsdPost ( title: String,  description: String): Boolean{
         return  (!title.isEmpty() && !description.isEmpty())
    }

    fun validateFieldGetPost (userId: Int){

    }
}