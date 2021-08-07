package com.example.main.diarylist

import com.example.main.diarylist.adapter.DiaryAdapter
import com.example.main.databinding.ActivityDiary2Binding
import com.example.main.diarylist.dia.Diary
import com.example.main.diarylist.sqlite.DiaryOpenHelper
import com.example.main.diarylist.viewmodel.MainModel
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.main.R
import java.util.*

class DiaryActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityDiary2Binding
    private lateinit var todies : Vector<Diary>
    private lateinit var adapter : DiaryAdapter



    companion object {
        private const val MAIN = R.layout.activity_diary2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, MAIN)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        todies = Vector()
        val openHelper = DiaryOpenHelper(this)
        val db = openHelper.writableDatabase
        val cursor = db.rawQuery("select * from diarylist", null)

        val count = cursor.count
        if (count >= 1) {
            while (cursor.moveToNext()) {
                val title = cursor.getString(0)
                val content = cursor.getString(1)
                val time = cursor.getString(2)
                todies.add(Diary(title, content, time))
            }
        } else {
            todies.add(Diary("등록된 다이어리가 없습니다.", "",""))
        }

        cursor.close()
        adapter = DiaryAdapter(todies, this)
        binding.recyclerView.adapter = adapter

        binding.mainModel = MainModel(this, this)
        binding.executePendingBindings()
    }
}
