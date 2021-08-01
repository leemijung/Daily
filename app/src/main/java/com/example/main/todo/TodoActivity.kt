package com.example.main.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.main.R
import kotlinx.android.synthetic.main.activity_todo.*
import kotlinx.android.synthetic.main.activity_todo.today_list
import kotlinx.android.synthetic.main.activity_todo.todo_add
import kotlinx.android.synthetic.main.activity_todo.todo_input
import kotlinx.android.synthetic.main.fragment_todo_fragment.*


class TodoActivity : AppCompatActivity() {
    lateinit var todayAdapter : TodoAdapter
    lateinit var viewModel : TodoViewModel
    lateinit var todoList: MutableLiveData<MutableList<Todo>>

    override fun onCreate(savedInstanceState: Bundle?) { //앱이 최초 실행 됐을 때 수행
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo) //xml 화면 뷰 연결

        //뷰모델 받아오기
        viewModel = ViewModelProvider(this, ViewModelProviderFactory(this.application))
            .get(TodoViewModel::class.java)

        //recycler view에 보여질 item Room에서 받아오기
        todoList = viewModel.mutableLiveData
        todoList.observe(this, Observer {
            todayAdapter.itemList = it
            todayAdapter.notifyDataSetChanged()
        })

        todayAdapter = TodoAdapter(this, mutableListOf<Todo>(), viewModel,::setList)

        //recycler view에 adapter와 layout manager 넣기
        today_list.setHasFixedSize(true)
        today_list.adapter = todayAdapter
        today_list.layoutManager = GridLayoutManager(this,1,RecyclerView.VERTICAL,false)//LinearLayoutManager(this)

        //Todo추가
        todo_add.setOnClickListener {
            if(todo_input.text.toString() != ""){
                val todo = Todo(todo_input.text.toString())
                viewModel.insert(todo)
                setList()
                todo_input.setText("")
            }
        }
    }

    // 화면을 다시 돌리기 위해 viewModel 내에 있는 LiveData의 value를 변경시켜줌.
    // value가 변경됨에 따라 observer에 설정된 함수가 실행되고 UI가 변경됨.
    fun setList(){
        todoList.value = viewModel.getList(viewModel.isTimeOrder)
    }

}