package ingfabian.userpost.presentation.ui.post

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.userpost.R
import ingfabian.userpost.databinding.ActivityPostBinding
import ingfabian.userpost.presentation.ConstantPresentation
import ingfabian.userpost.presentation.MainActivity
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityPostBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_post
        )
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        binding.postViewModel = postViewModel
        postAdapter = PostAdapter(ArrayList())
        recycleViewPost.layoutManager = LinearLayoutManager(this)
        recycleViewPost.adapter = postAdapter
        postViewModel.getAllUserPost ()
        setObservers ()


    }

    fun setObservers (){
        postViewModel.listPost.observe(this, Observer {
            if (it != null) {
                val postList = ArrayList<PostEntity>(it)
                postAdapter.updateInformation(postList)
            }
        })

        postViewModel.goToView.observe(this, Observer {
            when (it){
                ConstantPresentation.GO_TO_ADD_POST -> setIntent()
            }
        })
    }

    fun setIntent (){
        var intent= Intent ()
        intent.setClass(this, MainActivity::class.java)
        startActivity(intent)
    }
}
