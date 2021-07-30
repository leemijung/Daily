package com.example.main.diarylist

import com.example.main.databinding.ActivityDiarySub2Binding
import com.example.main.diarylist.sqlite.DiaryOpenHelper
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.main.R
import java.text.SimpleDateFormat
import java.util.*

class DiarySubActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityDiarySub2Binding

    private val format = SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN)

    companion object {
        private const val TODO = R.layout.activity_diary_sub2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, TODO)
        binding.goMainIv.setOnClickListener {
            onBackPressed()
        }
        binding.addNoteIv.setOnClickListener {
            val title = binding.titleEt.text
            val content = binding.todoContentEt.text
            if (title == null || content == null) {
                Toast.makeText(this, "제목과 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()

            } else {
                val time = format.format(Date())
                val db = DiaryOpenHelper(this).writableDatabase
                db.execSQL("insert into diarylist values (\'$title\', \'$content\', \'$time\')")
                db.close()
                Toast.makeText(this, "다이어리가 등록되었습니다.", Toast.LENGTH_SHORT).show()
                onBackPressed()
            }
        }
    }


    override fun onBackPressed() {
        startActivity(Intent(this, DiaryActivity2::class.java))
        finish()
    }
}