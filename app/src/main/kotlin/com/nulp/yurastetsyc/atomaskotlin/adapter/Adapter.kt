package com.nulp.yurastetsyc.atomaskotlin.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nulp.yurastetsyc.atomaskotlin.Data
import com.nulp.yurastetsyc.atomaskotlin.R
import kotlinx.android.synthetic.main.item_list_one.view.*

/**
 * Created by Yura Stetsyc on 2/13/17.
 */
class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    val ITEM_TYPE_ONE = 1
    val ITEM_TYPE_TWO = 2

    override fun getItemViewType(position: Int): Int {
        return position % 2 + 1
    }

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.bind(Data("Data for item at position $position"))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder? {
        when (viewType) {
            ITEM_TYPE_ONE -> return OneViewHolder(LayoutInflater.from(parent?.context)
                    .inflate(R.layout.item_list_one, parent, false))
            ITEM_TYPE_TWO -> return TwoViewHolder(LayoutInflater.from(parent?.context)
                    .inflate(R.layout.item_list_two, parent, false))
        }

        return null
    }

    class OneViewHolder(itemView: View) : ItemViewHolder(itemView) {

        override fun bind(data: Data) {
            val text: String = "OneViewHolder\n" + data.text
            itemView.textView.text = text
        }

    }

    class TwoViewHolder(itemView: View) : ItemViewHolder(itemView) {

        override fun bind(data: Data) {
            val text: String = "TwoViewHolder\n" + data.text
            itemView.textView.text = text
        }
    }

    abstract class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(data: Data)
    }

}