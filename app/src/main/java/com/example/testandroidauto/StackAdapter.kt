package com.example.testandroidauto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class StackAdapter(val stackItems: MutableList<String>) :
    RecyclerView.Adapter<StackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_stack, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stackItems.get(position))
    }

    override fun getItemCount(): Int {
        return stackItems.size
    }

    fun updateItems(newStackItems: ArrayList<String>) {
        stackItems.clear()
        stackItems.addAll(newStackItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text_view: TextView

        init {
            text_view = view.findViewById(R.id.text_view)
        }

        fun bind(text: String) {
            text_view.setText(text)
        }
    }
}