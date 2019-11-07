package buu.informatics.s59160625.aunzcoffee.screens.coffeeIngrediant


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
        holder.brewNum.text = (position+1).toString()
        holder.brewing.text = data[position].brewing
    }

    fun replaceBrew(items: List<MyBrewing>) {
        this.data = items
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val brewNum : TextView = itemView.findViewById(R.id.numBrew)
        val brewing : TextView = itemView.findViewById(R.id.brewText)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.brew_list_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}