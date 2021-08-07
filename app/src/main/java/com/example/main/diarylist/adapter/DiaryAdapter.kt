package com.example.main.diarylist.adapter

import com.example.main.databinding.ItemDiarylistBinding
import com.example.main.diarylist.dia.Diary
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.main.diarylist.DiarySubActivity2
import com.example.main.diarylist.sqlite.DiaryOpenHelper
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
        binding.diaryContentTv.text = todos[pos].content
        val time = "작성일 " + todos[pos].writeTime
        binding.noteDateTv.text = time

        //리사이클러뷰 아이템 누르면 편집화면으로 이동
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DiarySubActivity2::class.java)
            intent.putExtra("content", "데이터 보냄")
           intent.putExtra("no", 111)
            val no=intent.getLongExtra("no", -1)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

        //휴지통 누르면 삭제?????????????????????????????
//        binding.diaryDel.setOnClickListener{
//            var sql="delete from diarylist where idx=?"
//            var args=arrayOf(pos)
//
//        }

//        binding.diaryDel.setOnClickListener{
//            todos.removeAt(position)
//            notifyDataSetChanged()
//        }


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

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init{
            itemView.setOnClickListener{
               //리사이클러뷰 아이템 클릭시 실행되는 코드
            }
        }
    }
}