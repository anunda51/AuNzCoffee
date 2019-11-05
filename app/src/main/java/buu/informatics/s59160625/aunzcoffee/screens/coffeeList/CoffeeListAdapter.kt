package buu.informatics.s59160625.aunzcoffee.screens.coffeeList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.data.MyCoffee

class CoffeeListAdapter: RecyclerView.Adapter<CoffeeListAdapter.ViewHolder>() {
    var data = listOf<MyCoffee>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coffeeListBtn.text = data[position].coffee_name
        holder.coffeeListBtn.setOnClickListener {
            it.findNavController().navigate(CoffeeListPageDirections.actionCoffeeListPageToCoffeeIngrediantPage(coffeeName = data.get(position).coffee_name))
        }
    }

    fun replaceItems(items: List<MyCoffee>) {
        this.data = items
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val coffeeListBtn : Button = itemView.findViewById(R.id.coffeeListBtn)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.coffee_list_recycle_view, parent, false)

                return ViewHolder(view)
            }
        }
    }
}