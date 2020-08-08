package ingfabian.userpost.presentation.ui.custom_views


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ingfabian.userpost.R


class CoachPromotionalAdapter(var list: MutableList<ViewHolderItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var mInflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mInflater = LayoutInflater.from(parent.context)
        var view: View? = null
        var selectViewHolder: RecyclerView.ViewHolder? = null
        when (viewType) {
            1 -> {
                view = mInflater.inflate(R.layout.item_coach_layout, parent, false)
                selectViewHolder = ViewHolder(view!!)
            }
        }
        return selectViewHolder!!
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list.get(position).CUSTOM_COACH) {
            1 -> setViewCustomCoach(holder as ViewHolder, position)
        }
    }

    fun setViewCustomCoach(holder: ViewHolder, position: Int) {
        val nombre: String = (list.get(position) as CoachCardPresentation).nombre
        holder.textView.setText(nombre)
    }

    override fun getItemViewType(position: Int): Int {
        return (list.get(position) as ViewHolderItem).viewType
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.textViewName)
    }
}