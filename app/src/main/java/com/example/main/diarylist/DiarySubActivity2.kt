package com.example.main.diarylist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.main.BottomNavigation
import com.example.main.R
import com.example.main.databinding.ActivityDiarySub2Binding
import com.example.main.diarylist.sqlite.DiaryOpenHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
                startActivity(Intent(this, BottomNavigation::class.java))
            }
        }
        //리사이클러뷰 목록 중 하나 누르면 내용 이어받기
        intent=getIntent()
        binding.titleEt.setText(intent.getStringExtra("title1"))
        binding.todoContentEt.setText(intent.getStringExtra("content1"))


        //다이어리 수정
        binding.editNote.setOnClickListener{
            val etime = format.format(now)
            val etitle = binding.titleEt.text
            val econtent = binding.todoContentEt.text
            if (etitle.length<=0 || econtent.length<=0) {
                Toast.makeText(this, "제목과 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val etime = format.format(now)
                val db = DiaryOpenHelper(this).writableDatabase
                db.execSQL("update diarylist set title='"+etitle+"',"+"content='"+econtent+"',"+"write_date='"+etime+"' where title='"+intent.getStringExtra("title1")+"'")
                db.close()
                Toast.makeText(this, "다이어리가 수정되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
                startActivity(Intent(this, BottomNavigation::class.java))
            }
        }
    }

    //뒤로가기 눌렀을때 가는 화면
    override fun onBackPressed() {
        startActivity(Intent(this, BottomNavigation::class.java))
        finish()
    }
}