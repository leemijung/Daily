package com.example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

//, BottomNavigationView.OnNavigationItemSelectedListener
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bottom_navigationview.setOnNavigationItemSelectedListener(this)

        val CalendarView = findViewById<CalendarView>(R.id.calendarView)

        CalendarView?.setOnDateChangeListener {view, year, month, dayOfMonth ->
            val msg:String = year.toString() +"/"+ month.toString() +"/"+ dayOfMonth.toString()
            runOnUiThread {
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show() //날짜 터치시 알림표시로 나타내기
            }
        }
    }
}