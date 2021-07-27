//todoActivity 내용을 fragment로 바꿔야 함



//package com.example.main.todo
//
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.main.R
//import kotlinx.android.synthetic.main.todo_main.*
//import java.util.*
//
//class todo_fragment : Fragment() {
//
//    lateinit var todayAdapter : TodoAdapter
//    lateinit var viewModel : TodoViewModel
//    lateinit var todoList: MutableLiveData<MutableList<Todo>>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val rootView = inflater.inflate(R.layout.fragment_calendar_fragment, container, false) as ViewGroup
//
//
//        //뷰모델 받아오기
//        viewModel = ViewModelProvider(this, ViewModelProviderFactory(this))
//            .get(TodoViewModel::class.java)
//
//        //recycler view에 보여질 item Room에서 받아오기
//        todoList = viewModel.mutableLiveData
//        todoList.observe(viewLifecycleOwner, Observer {
//            todayAdapter.itemList = it
//            todayAdapter.notifyDataSetChanged()
//        })
//
//        todayAdapter = TodoAdapter(this, mutableListOf<Todo>(), viewModel,::setList)
//
//        //recycler view에 adapter와 layout manager 넣기
//        today_list.adapter = todayAdapter
//        today_list.layoutManager = LinearLayoutManager(context)
//
//        //Todo추가
//        todo_add.setOnClickListener {
//            if(todo_input.text.toString() != ""){
//                val todo = Todo(todo_input.text.toString())
//                viewModel.insert(todo)
//                setList()
//                todo_input.setText("")
//            }
//        }
//
//
//        //뷰 반환
//        return rootView
//
//    }
//
//}
