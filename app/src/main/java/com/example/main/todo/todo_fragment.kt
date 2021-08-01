//todoActivity 내용을 fragment로 바꿔야 함

package com.example.main.todo


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.main.R
import kotlinx.android.synthetic.main.activity_todo.*
import kotlinx.android.synthetic.main.fragment_todo_fragment.*
import kotlinx.android.synthetic.main.fragment_todo_fragment.ftoday_list

class todo_fragment : Fragment() {

    lateinit var todayAdapter : TodoAdapter
    lateinit var viewModel : TodoViewModel
    lateinit var todoList: MutableLiveData<MutableList<Todo>>
    lateinit var todoAdd : Button
    lateinit var todoInput : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_todo_fragment, container, false) as ViewGroup



        //뷰모델 받아오기
        viewModel = ViewModelProvider(this, ViewModelProviderFactory(requireContext()))
            .get(TodoViewModel::class.java)

        //recycler view에 보여질 item Room에서 받아오기
        todoList = viewModel.mutableLiveData
        todoList.observe(viewLifecycleOwner, {
            todayAdapter.itemList = it
            todayAdapter.notifyDataSetChanged()
        })

        todayAdapter = TodoAdapter(requireContext(), mutableListOf<Todo>(), viewModel,::setList)

        //today_list.setHasFixedSize(true)
//        recycler view에 adapter와 layout manager 넣기
//        today_list.adapter = todayAdapter
//        ftoday_list.layoutManager = LinearLayoutManager(context)

//        todo_add = rootView.findViewById(R.id.todo_add)
//        //Todo추가
//        todo_add.setOnClickListener {
//            if(todo_input.text.toString() != ""){
//                val todo = Todo(todo_input.text.toString())
//                viewModel.insert(todo)
//                setList()
//                todo_input.setText("")
//            }
//        }
        //뷰 반환
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ftoday_list.setHasFixedSize(true)
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            ftoday_list.layoutManager = LinearLayoutManager(context)
        }
        ftoday_list.apply {
            this.adapter = todayAdapter
            setHasFixedSize(true)
            val gridLayout = GridLayoutManager(context,1)
            layoutManager = gridLayout
        }
        todoAdd = view.findViewById(R.id.todo_add)
        todoInput = view.findViewById(R.id.todo_input)
        //Todo추가
        todoAdd.setOnClickListener {
            if(todoInput.text.toString() != ""){
                val todo = Todo(todoInput.text.toString())
                viewModel.insert(todo)
                setList()
                todoInput.setText("")
            }
        }
    }
    fun setList(){
        todoList.value = viewModel.getList(viewModel.isTimeOrder)
    }

}
