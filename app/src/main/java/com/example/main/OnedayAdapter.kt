package com.example.main

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class OnedayAdapter(val onedayList: ArrayList<OnedayDiary>) : RecyclerView.Adapter<OnedayAdapter.CustomViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnedayAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return onedayList.size
    }

    override fun onBindViewHolder(holder: OnedayAdapter.CustomViewHolder, position: Int) {
        holder.contentfirst.text = onedayList.get(position).content

    }
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val contentfirst = itemView.findViewById<TextView>(R.id.mycontent) //내용
    }


}
