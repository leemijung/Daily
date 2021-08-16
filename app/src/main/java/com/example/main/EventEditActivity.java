package com.example.main;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.main.R;

import java.time.LocalTime;
@RequiresApi(api = Build.VERSION_CODES.O)

public class EventEditActivity extends AppCompatActivity {

    private EditText eventNameET;
    private TextView eventDateTV,eventTimeTV;
    private LocalTime time;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("날짜 : " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("시간 : " + CalendarUtils.formattedTime(time));
    }

    private void initWidgets() {
        eventNameET =findViewById(R.id.eventNameET);
        eventDateTV =findViewById(R.id.eventDateTV);
        eventTimeTV =findViewById(R.id.eventTimeTV);
    }

    public void saveEventAction(View view) {
        String eventName=eventNameET.getText().toString();
        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);
        finish();
    }
}