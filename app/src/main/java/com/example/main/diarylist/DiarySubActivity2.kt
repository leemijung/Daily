package com.example.main.diarylist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.main.MainActivity
import com.example.main.R
import com.example.main.databinding.ActivityDiarySub2Binding
import com.example.main.diarylist.sqlite.DiaryOpenHelper
import com.example.main.todo.todo_fragment
import java.text.SimpleDateFormat
import java.util.*


class DiarySubActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityDiarySub2Binding
    val now=System.currentTimeMillis()
    private val format = SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN)

    companion object {
        private const val TODO = R.layout.activity_diary_sub2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, TODO)

        //메인으로 가는 버튼 클릭시
        binding.goMainIv.setOnClickListener {
            finish()
        }
        //저장버튼 클릭시 db에 저장
        binding.addNoteIv.setOnClickListener {
            val time = format.format(now)
            val title = binding.titleEt.text
            val content = binding.todoContentEt.text
            if (title.length<=0 || content.length<=0) {
                Toast.makeText(this, "제목과 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val db = DiaryOpenHelper(this).writableDatabase
                db.execSQL("insert into diarylist values (\'$title\', \'$content\', \'$time\')")
                db.close()
                Toast.makeText(this, "다이어리가 등록되었습니다.", Toast.LENGTH_SHORT).show()

                finish()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        //리사이클러뷰 누르면 내용 이어받기
        intent=getIntent()
        binding.titleEt.setText(intent.getStringExtra("title1"))
        binding.todoContentEt.setText(intent.getStringExtra("content1"))
//현재 문제점 : db가 수정이 안됨 (이전의 내역들이 같이 나옴), 수정한 일기가 기존의 것이 아닌 새로운 view로 나옴



        //다이어리 수정
//        binding.editNote.setOnClickListener{
//            val etitle = binding.titleEt.text
//            val econtent = binding.todoContentEt.text
//            if (etitle.length<=0 || econtent.length<=0) {
//                Toast.makeText(this, "제목과 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
//            } else {
//                val etime = format.format(now)
//                val db = DiaryOpenHelper(this).writableDatabase
//                db.execSQL("update diarylist set ")
//                db.close()
//                Toast.makeText(this, "다이어리가 수정되었습니다.", Toast.LENGTH_SHORT).show()
//
//                finish()
//                startActivity(Intent(this, MainActivity::class.java))
//            }
//        }
    }

    //뒤로가기 눌렀을때 가는 화면
    override fun onBackPressed() {
        startActivity(Intent(this, DiaryActivity2::class.java))
        finish()
    }
}