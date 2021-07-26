package com.example.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView :MaterialCalendarView=findViewById(R.id.main_calendarView)

        //var startTimeCalendar = Calendar.getInstance()
        //var endTimeCalendar = Calendar.getInstance()

        //val currentYear = startTimeCalendar.get(Calendar.YEAR)
        //val currentMonth = startTimeCalendar.get(Calendar.MONTH)
        //val currentDate = startTimeCalendar.get(Calendar.DATE)

        //endTimeCalendar.set(Calendar.MONTH, currentMonth + 3)

        //calendarView.state().edit()
        //        .setFirstDayOfWeek(Calendar.SUNDAY)
        //        .setMinimumDate(CalendarDay.from(currentYear, currentMonth, 1))
        //        .setMaximumDate(CalendarDay.from(currentYear, currentMonth + 3, endTimeCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)))
        //        .setCalendarDisplayMode(CalendarMode.MONTHS)
        //        .commit()


        //토-파랑, 일-빨강   캘린더 색상변경
        val saturdayDecorator = SaturdayDecorator()
        val sundayDecorator = SundayDecorator()
        calendarView.addDecorators(saturdayDecorator, sundayDecorator)



    }
}