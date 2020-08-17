package com.example.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView

class SelectTopics : CardView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    lateinit var textViewDescription: TextView

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.topic_selected, this, false)
        bindViewReferences(view)
        addView(view)
    }

    fun bindViewReferences(view: View) {
        textViewDescription = view.findViewById(R.id.textViewContent)
    }

    fun selectTopic(view: View) {

    }

    fun deselectTopic(view: View) {

    }

    fun getView(): Int {
        return R.layout.topic_selected

    }

    data class TopicsView(val description: String, val color: Int)

}