package buu.informatics.s59160625.aunzcoffee.screens.myFavorite

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.database.Coffee

class MyFavortieAdapter : RecyclerView.Adapter<MyFavortieAdapter.ViewHolder>(){
    var data = listOf<Coffee>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("test","Start")
        return ViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val coffeeName: TextView = itemView.findViewById(R.id.coffeeName)
        val detailBtn: Button = itemView.findViewById(R.id.detailBtn)

        fun bind(item: Coffee) {
            coffeeName.text = item.coffeeName
            detailBtn.setOnClickListener {
                it.findNavController().navigate(MyFavoriteFragmentDirections.actionMyFavoriteToCoffeeIngrediantPage(coffeeName = item.coffeeName))
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.my_favorite_item, parent, false)

                return ViewHolder(
                    view
                )
            }
        }
    }
}