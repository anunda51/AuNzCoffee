package buu.informatics.s59160625.aunzcoffee.testRecycleView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160625.aunzcoffee.R

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    var data = listOf<MyData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("test","Start")
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.contentTextView.text = data[position].content
//        holder.sourceTextView.text = _data[position].source
    }

    fun replaceItems(items: List<MyData>) {
        this.data = items
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.my_list_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}