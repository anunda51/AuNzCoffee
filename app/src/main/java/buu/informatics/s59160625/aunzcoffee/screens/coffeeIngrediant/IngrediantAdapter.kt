package buu.informatics.s59160625.aunzcoffee.screens.coffeeIngrediant

import android.util.Log
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
        holder.ingrediantName.text = data[position].ingrediant_name
    }

    fun replaceItems(items: List<MyIngrediant>) {
        this.data = items
        Log.i("checkItem",items.toString())
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ingrediantName : TextView = itemView.findViewById(R.id.ingrediantText)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.ingrediant_list_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}