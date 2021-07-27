package com.example.main


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.util.*

class calendar_fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //fragment에서 findViewById를 사용하기 위해 선언
        val rootView = inflater.inflate(R.layout.fragment_calendar_fragment, container, false) as ViewGroup

        val plusbutton: Button = rootView.findViewById(R.id.plusButton) as Button
        val main_calendarView: MaterialCalendarView =
            rootView.findViewById(R.id.main_calendarView) as MaterialCalendarView

        //일정 편집화면으로 이동
        plusbutton.setOnClickListener {
            activity?.let {
                val intent = Intent(context, SettingsActivity::class.java)
                startActivity(intent)
            }
        }

        //토-파랑, 일-빨강   캘린더 색상변경
        val saturdayDecorator = SaturdayDecorator()
        val sundayDecorator = SundayDecorator()
        main_calendarView.addDecorators(saturdayDecorator, sundayDecorator)

        //뷰 반환
        return rootView

    }

}
