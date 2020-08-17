package ingfabian.userpost.presentation.ui.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customview.AutofitGridLayout
import com.example.customview.SelectTopics
import com.example.customview.SelectTopicsAdapter
import ingfabian.userpost.R

class TopicsFragment : Fragment() {

    lateinit var gridLayout: GridLayout
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SelectTopicsAdapter
    lateinit var gridLayoutManager: AutofitGridLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_topics, container, false)
        val listTopics = arrayListOf<String>(
            "Android",
            "iOS",
            "Web",
            "PhoneGap",
            "Xamarin",
            "iONIC"
        )
        recyclerView = view.findViewById(R.id.recycleViewTopics)
        adapter = SelectTopicsAdapter(listTopics)

        gridLayoutManager = AutofitGridLayout(this.context!!, 3)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()
        return view
    }

    companion object {
        @SuppressLint("ShowToast")
        fun newInstance(param1: String, param2: String) =
            TopicsFragment().apply {

            }
    }
}

private fun GridLayout.addView(listTopics: ArrayList<SelectTopics>) {

    for (x in 0..(listTopics.size - 1)) {
        this.addView(listTopics.get(x))
    }
}
