package com.example.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.main.databinding.ActivityDiaryBinding

class DiaryActivity : AppCompatActivity() {

    val binding by lazy {ActivityDiaryBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val onedayList = arrayListOf(
            OnedayDiary("영화 본 날"),
            OnedayDiary("책 읽은 날"),
            OnedayDiary("놀러 간 날")
        )
        binding.daylist.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.daylist.setHasFixedSize(true) //성능 개선 방안

        binding.daylist.adapter = OnedayAdapter(onedayList)

        //+클릭시 다음 화면으로 넘어가기
        binding.buttonnew.setOnClickListener {
            val intent= Intent(this, DiarySubActivity::class.java)
            startActivity(intent)
        }

    }


}
