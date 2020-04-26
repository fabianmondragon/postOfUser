package ingfabian.userpost.presentation.ui.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.userpost.R

class PostAdapter (private var dataSet: ArrayList<PostEntity>) : RecyclerView.Adapter<PostAdapter.ViewHolderPost>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        val viewHolderPost = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false) as TextView
        return ViewHolderPost(viewHolderPost)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        holder.textViewTitle.text = dataSet[position].title
        holder.textViewDescription.text = dataSet[position].description
    }

    fun updateInformation (dataSet: ArrayList<PostEntity>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }


    class ViewHolderPost(itemsView: View): RecyclerView.ViewHolder(itemsView) {

        val textViewTitle: TextView = itemsView.findViewById(R.id.textViewItemTitle)
        val textViewDescription: TextView = itemsView.findViewById(R.id.textViewItemDescription)

    }


}