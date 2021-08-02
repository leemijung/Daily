package com.example.main.todo

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.main.R
import kotlinx.android.synthetic.main.todolist_item.view.*
import com.example.main.todo.Todo
import com.example.main.todo.TodoViewModel
import java.util.*

class TodoAdapter(val context: Context,
                  var itemList: MutableList<Todo>,
                  val viewModel: TodoViewModel,
                  val setList: () -> Unit)
    : RecyclerView.Adapter<TodoAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.todolist_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // position에 해당하는 Todo객체를 얻음
        var todo = itemList[position]

        holder.todoText.text = todo.text

        //Todo객체의 isDone을 CheckBox의 isChecked에 set해줌
        holder.todoIsDone.isChecked = todo.isDone

        //Todo가 완료(done)된 상태라면 todo_text의 글자색 변경 후 취소선 추가
        if(todo.isDone){
            holder.todoText.apply {
                setTextColor(Color.GRAY)
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                setTypeface(null, Typeface.ITALIC)
            }
        } else{ //완료상태가 아니라면 글자색 복구, 취소선 없앰
            holder.todoText.apply {
                setTextColor(Color.BLACK)
                paintFlags=0
                setTypeface(null, Typeface.NORMAL)
            }
        }

        //CheckBox인 todoIsDone이 클릭되었을 때
        holder.todoIsDone.apply {
            setOnClickListener {
                todo.isDone = this.isChecked
                viewModel.update(todo)
                // 변경이 완료되었으므로 다시 TodoList를 받아온 후
                //liveData.value에 넣어주는 setList method 실행
                setList()
            }
        }

        //item 내의 휴지통 버튼을 누를 경우 삭제 여부 확인
        holder.todoDelete.setOnClickListener {
            val todo = itemList[position]
            viewModel.delete(todo)
            setList()
        }
    }



    class CustomViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val todoText = itemView.todo_text
        val todoInfo = itemView.todo_info
        val todoDelete = itemView.todo_delete
        val todoIsDone: CheckBox = itemView.todo_done
    }
}