package com.example.main


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import kotlinx.android.synthetic.main.calendar_main.*
import java.util.*


class CalendarActivity : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView = inflater.inflate(R.layout.calendar_main, container, false) as ViewGroup

        val plusbutton: Button = rootView.findViewById(R.id.plusButton) as Button
        val main_calendarView: MaterialCalendarView = rootView.findViewById(R.id.main_calendarView) as MaterialCalendarView


//        plusbutton.setOnClickListener {
//            val intent = Intent(getActivity(), SettingsActivity::class.java)
//            startActivity(intent)
//        }

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

        return rootView


    }





}


//class CalendarActivity : AppCompatActivity() {
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.calendar_main)
//
//        val calendarView: MaterialCalendarView = findViewById(R.id.main_calendarView)
//
//        plusButton.setOnClickListener {
//            val intent = Intent(this, SettingsActivity::class.java)
//            startActivity(intent)
//        }
//
//        //토-파랑, 일-빨강   캘린더 색상변경
//        val saturdayDecorator = SaturdayDecorator()
//        val sundayDecorator = SundayDecorator()
//        calendarView.addDecorators(saturdayDecorator, sundayDecorator)
//
//
//    }
//}
//
//
