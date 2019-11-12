package buu.informatics.s59160625.aunzcoffee.screens.myFavorite

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
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
        private val coffeeName: TextView = itemView.findViewById(R.id.coffeeName)
        private val coffeeImage: ImageView = itemView.findViewById(R.id.coffeeImage)

        fun bind(item: Coffee) {
            coffeeName.text = item.coffeeName
//            when (item.coffeeName){
//                "คาปูชิโน่" -> coffeeImage.setImageResource(R.drawable.capu)
//                "ลาเต้" -> coffeeImage.setImageResource(R.drawable.latte)
//                "มอคค่า" -> coffeeImage.setImageResource(R.drawable.mocha)
//                "เอสเพรสโซ่" -> coffeeImage.setImageResource(R.drawable.espresso)
//                "อเมริกาโน่" -> coffeeImage.setImageResource(R.drawable.americano)
//                "ชานม" -> coffeeImage.setImageResource(R.drawable.tea)
//                "ชาเขียว" -> coffeeImage.setImageResource(R.drawable.greentea)
//                "ชามะลิ" -> coffeeImage.setImageResource(R.drawable.jasminetea)
//                "ชาดำ" -> coffeeImage.setImageResource(R.drawable.blacktea)
//                "ชามะนาว" -> coffeeImage.setImageResource(R.drawable.lemontea)
//            }
            coffeeImage.setOnClickListener {
                it.findNavController().navigate(MyFavoriteFragmentDirections.actionMyFavoriteToCoffeeIngrediantPage(coffeeName = item.coffeeName))
            }
            coffeeName.setOnClickListener {
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