package com.example.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.main.databinding.ActivityDiaryBinding


class diary_fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //fragment에서 findViewById를 사용하기 위해 선언
        val rootView = inflater.inflate(R.layout.fragment_diary_fragment, container, false) as ViewGroup

        val daylist: RecyclerView = rootView.findViewById(R.id.daylist) as RecyclerView
        val button_new: Button = rootView.findViewById(R.id.button_new) as Button

        val onedayList = arrayListOf(
            OnedayDiary("영화 본 날"),
            OnedayDiary("책 읽은 날"),
            OnedayDiary("놀러 간 날")
        )
        daylist.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        daylist.setHasFixedSize(true) //성능 개선 방안

        daylist.adapter = OnedayAdapter(onedayList)

        //+클릭시 다음 화면으로 넘어가기
        button_new.setOnClickListener {
            activity?.let {
                val intent = Intent(context, DiarySubActivity::class.java)
                startActivity(intent)
            }
        }

        //뷰 반환
        return rootView
    }


}