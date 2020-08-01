package ingfabian.userpost.presentation.ui.custom_views


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ingfabian.userpost.R

class CoachPromotionalAdapter(var list: MutableList<CoachCardPresentation>) :
    RecyclerView.Adapter<CoachPromotionalAdapter.ViewHolder>() {

    lateinit var mInflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mInflater = LayoutInflater.from(parent.context)
        val view: View = mInflater.inflate(R.layout.item_coach_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CoachPromotionalAdapter.ViewHolder, position: Int) {
        val nombre: String = list.get(position).nombre
        holder.textView.setText(nombre)
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.textViewName)
    }
}