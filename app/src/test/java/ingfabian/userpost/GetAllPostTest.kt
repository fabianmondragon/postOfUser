package ingfabian.userpost

import ingfabian.core.repository.PostRepository
import ingfabian.core.usecases.GetAllPost
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.core.usecases.entity.UserEntity
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAllPostTest {

    @Mock
    private lateinit var getAllPostRepository: PostRepository

    @Test
    fun getAllPostbyUser_WithValidUser_Success (){

        //Arrange
        var listOfPostUser: ArrayList<PostEntity>? = null
        val getAllPost= GetAllPost (getAllPostRepository)
        var userEntity = UserEntity(1, "Fabian", "",18, "")
        var listPost = ArrayList<PostEntity>()
        listPost.add(PostEntity("Title1", "Descripcion1", 1))
        listPost.add(PostEntity("Title2", "Descripcion2", 1))
        listPost.add(PostEntity("Title3", "Descripcion3", 1))


        //Act
        runBlockingTest {
            Mockito.`when`(getAllPostRepository.getPostByUser(1)).thenReturn(listPost)
             listOfPostUser= getAllPost.getPostByUser (userEntity) as ArrayList<PostEntity>?

        }

        //Assert
        MatcherAssert.assertThat(listPost, CoreMatchers.`is`(CoreMatchers.equalTo(listOfPostUser)))
    }

    @Test
    fun getAllPostbyUser_WithUserInvalid_Success (){

        //Arrange
        var listOfPostUser: ArrayList<PostEntity>? = null
        val getAllPost= GetAllPost (getAllPostRepository)
        var userEntity = UserEntity(1, "Fabian", "",18, "")
        var listPost = ArrayList<PostEntity>()
        listPost.add(PostEntity("Title1", "Descripcion1", 1))
        listPost.add(PostEntity("Title2", "Descripcion2", 1))
        listPost.add(PostEntity("Title3", "Descripcion3", 1))
        //Act
        runBlockingTest {
            Mockito.`when`(getAllPostRepository.getPostByUser(1)).thenReturn(listPost)
            listOfPostUser= getAllPost.getPostByUser (userEntity) as ArrayList<PostEntity>?

        }
        //Assert
        MatcherAssert.assertThat(null, CoreMatchers.equalTo(listOfPostUser))
    }

}