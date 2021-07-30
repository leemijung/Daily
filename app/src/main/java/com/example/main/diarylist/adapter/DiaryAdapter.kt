package com.example.main.diarylist.adapter

import com.example.main.databinding.ItemDiarylistBinding
import com.example.main.diarylist.dia.Diary
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*

class DiaryAdapter(private var todos: Vector<Diary>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemDiarylistBinding.inflate(LayoutInflater.from(context),parent, false)
        return ItemHoder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ItemHoder
        val binding = itemHolder.binding
        val pos = (todos.size - 1) - position
        binding.todoTitleTv.text = todos[pos].title
        val time = "작성일 " + todos[pos].writeTime
        binding.noteDateTv.text = time

    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class ItemHoder : RecyclerView.ViewHolder {
        var binding: ItemDiarylistBinding

        constructor(binding: ItemDiarylistBinding) : super(binding.root) {
            this.binding = binding
        }
    }

}