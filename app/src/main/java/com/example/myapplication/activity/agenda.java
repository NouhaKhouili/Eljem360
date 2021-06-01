package com.example.myapplication.activity;


import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class agenda extends AppCompatActivity {
    private static final String TAG ="agenda";
 private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        calendarView = (CalendarView) findViewById(R.id.calander);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
             String date= year + "/"+ month + "/"+dayOfMonth;
                Log.d(TAG,"onSelectDateChange : date");
            }
        });
    }
}
