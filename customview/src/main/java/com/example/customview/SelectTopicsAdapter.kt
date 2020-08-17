package com.example.customview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelectTopicsAdapter(val listSelectTopics: ArrayList<String>) : RecyclerView.Adapter<SelectTopicsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

         val view = LayoutInflater.from(parent.context).inflate(R.layout.item_topics, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSelectTopics.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewDescription.text = listSelectTopics[position]
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var textViewDescription : TextView

        init {
            bindReferences ()
        }

        fun bindReferences (){
            textViewDescription = itemView.findViewById(R.id.textViewContent)
        }
    }
}