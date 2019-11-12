package buu.informatics.s59160625.aunzcoffee.screens.detail


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.data.MyBrewing

class BrewAdapter: RecyclerView.Adapter<BrewAdapter.ViewHolder>() {
    var data = listOf<MyBrewing>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, position)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val brewNum : TextView = itemView.findViewById(R.id.numBrew)
        private val brewing : TextView = itemView.findViewById(R.id.brewText)

        fun bind(item: MyBrewing, position: Int) {
            brewNum.text = (position+1).toString()
            brewing.text = item.brewing
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.brew_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}