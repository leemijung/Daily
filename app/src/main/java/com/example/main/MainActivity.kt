package com.example.main


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main.diarylist.diary2_fragment
import com.example.main.todo.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var todoActivity: todo_fragment? = null
    var calendarActivity: calendar_fragment? = null
    var diaryActivity: diary2_fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoActivity = todo_fragment()
        calendarActivity = calendar_fragment()
        diaryActivity = diary2_fragment()
        supportFragmentManager.beginTransaction().replace(R.id.main_container, calendarActivity!!).commit()
        val bottom_menu = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_menu.setSelectedItemId(R.id.calendar);
        bottom_menu.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            //하단 메뉴바 아이콘에 따라 화면 이동
            when (item.itemId) {
                R.id.todo -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, todoActivity!!).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.calendar -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, calendarActivity!!).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.diary -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, diaryActivity!!).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

    }
}

