package com.example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_diary_sub.*
import kotlinx.android.synthetic.main.date_edit.*
import kotlinx.android.synthetic.main.date_edit.button2

class DiarySubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_sub)

        //취소 버튼
        buttoncancel.setOnClickListener{
            finish()
        }
    }
}
