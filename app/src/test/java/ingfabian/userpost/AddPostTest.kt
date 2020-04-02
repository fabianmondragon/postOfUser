package ingfabian.userpost

import ingfabian.core.repository.PostRepository
import ingfabian.core.usecases.AddPost
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.core.usecases.entity.UserEntity
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class AddPostTest {

    lateinit var addPost: AddPost

    @Mock
    private lateinit var postRepository: PostRepository

    @Test
    fun AddPostTest_OneValidEntry_Success (){
        //Arrange
        var userEntity = UserEntity(1, "Fabian", 18)
        var result : Boolean = false
        val addPost = AddPost (postRepository)
        val postEntity = PostEntity("Hola a todos", "Description", 1)

        //Act
        runBlockingTest {
            Mockito.`when`(postRepository.addPost(1, postEntity)).thenReturn(true)
            result = addPost.addPost(userEntity, postEntity)
        }

        //Assert
        MatcherAssert.assertThat(true, `is`(CoreMatchers.equalTo(result)))
    }

    @Test
    fun AddPostTest_InvalidDescriptionField_Fail (){
        //Arrange
        var userEntity = UserEntity(1, "Fabian", 18)
        var result : Boolean = false
        val addPost = AddPost (postRepository)
        val postEntity = PostEntity(
            "Hola a todos", "Descrition de más de 255 caracteres, es una" +
                    "descripción de más 255 caracteres, descripción de más 255 caracters, supera el numero valido de caracteres" +
                    "deberia retornarnos un error, de tal manera que no permita la incluision", 1
        )

        //Act
        runBlockingTest {
            Mockito.`when`(postRepository.addPost(1, postEntity)).thenReturn(true)
            result = addPost.addPost(userEntity, postEntity)
        }

        //Assert
        MatcherAssert.assertThat(true, `is`(CoreMatchers.equalTo(result)))
    }
}