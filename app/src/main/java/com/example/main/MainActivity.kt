package com.example.main


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main.todo.TodoActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    var todoActivity: TodoActivity? = null
    var calendarActivity: calendar_fragment? = null
    var diaryActivity: DiaryActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoActivity = TodoActivity()
        calendarActivity = calendar_fragment()
        diaryActivity = DiaryActivity()
        supportFragmentManager.beginTransaction().replace(R.id.main_container, calendarActivity!!).commit()
        val bottom_menu = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_menu.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
//                R.id.todo -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.container, todoActivity!!).commit()
//                    return@OnNavigationItemSelectedListener true
//                }
                R.id.calendar -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, calendarActivity!!).commit()
                    return@OnNavigationItemSelectedListener true
                }
//                R.id.diary -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.container, diaryActivity!!).commit()
//                    return@OnNavigationItemSelectedListener true
//                }
            }
            false
        })
    }
}

