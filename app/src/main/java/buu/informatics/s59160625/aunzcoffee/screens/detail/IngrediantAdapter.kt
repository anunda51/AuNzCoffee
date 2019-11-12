package buu.informatics.s59160625.aunzcoffee.screens.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.data.MyIngrediant

class IngrediantAdapter: RecyclerView.Adapter<IngrediantAdapter.ViewHolder>() {
    var data = listOf<MyIngrediant>()
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
        private val ingrediantNum : TextView = itemView.findViewById(R.id.num)
        private val ingrediantName : TextView = itemView.findViewById(R.id.ingrediantText)


        fun bind(item: MyIngrediant, position: Int) {
            ingrediantNum.text = (position+1).toString()
            ingrediantName.text = item.ingrediant_name
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.ingrediant_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}