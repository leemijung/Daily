package com.example.main;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.main.R;

import java.time.LocalTime;
import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.O)

public class EventEditActivity extends AppCompatActivity {

    private EditText eventNameET;
    private TextView eventDateTV,eventTimeTV;
    private LocalTime time;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog1;
    private TimePickerDialog timePickerDialog1;
    private Button dateButton;
    private Button timeButton;
    private Button dateButton1;
    private Button timeButton1;
    public int start_time;
    public int end_time;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("날짜 : " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("시간 : " + CalendarUtils.formattedTime(time));

        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        initTimePicker();
        timeButton = findViewById(R.id.timePickerButton);
        timeButton.setText(getNowTime());


        initDatePicker1();
        dateButton1 = findViewById(R.id.datePickerButton1);
        dateButton1.setText(getTodaysDate());

        initTimePicker1();
        timeButton1 = findViewById(R.id.timePickerButton1);
        timeButton1.setText(getNowTime());

        Button imageButton = (Button) findViewById(R.id.alarmbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainAlarmActivity.class);
                startActivity(intent);
            }
        });

    }

    private String getNowTime()
    {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);

        return makeTimeString(minute, hour);
    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }


    private void initTimePicker()
    {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                String time = makeTimeString(minute, hourOfDay);
                timeButton.setText(time);

            }
        };

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hour,minute,true);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }



    private void initTimePicker1()
    {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                String time = makeTimeString(minute, hourOfDay);
                timeButton1.setText(time);

            }
        };

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        timePickerDialog1 = new TimePickerDialog(this, style, timeSetListener, hour,minute,true);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }
    private void initDatePicker1()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton1.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog1 = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }




    private String makeDateString(int day, int month, int year)
    {
        return year + "년" + " " + month + "월" + " " + day + "일";
    }

    private String makeTimeString(int minute, int hour)
    {
        return hour + "시" + " " + minute + "분";
    }




    private void initWidgets() {
        eventNameET =findViewById(R.id.eventNameET);
        eventDateTV =findViewById(R.id.eventDateTV);
        eventTimeTV =findViewById(R.id.eventTimeTV);
    }

    public void saveEventAction(View view) {
        String eventName=eventNameET.getText().toString();
        if(!eventName.equals("")){
            Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time);
            Event.eventsList.add(newEvent);
            finish();
        }
        else{
            Toast.makeText(this, "일정을 입력하세요", Toast.LENGTH_LONG).show();
        }
    }

    public void openDatePicker1(View view)
    {
        datePickerDialog.show();
    }
    public void openDatePicker2(View view)
    {
        datePickerDialog1.show();
    }
    public void openTimePicker1(View view)
    {
        timePickerDialog.show();
    }
    public void openTimePicker2(View view)
    {
        timePickerDialog1.show();
    }
}