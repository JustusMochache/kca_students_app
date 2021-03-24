package com.example.kca_student_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.DatePicker;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.builders.DatePickerBuilder;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;
import com.example.kca_student_app.ui.AddNoteActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CalendarActivity extends AppCompatActivity {


    private OnSelectDateListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        //add calendar events with icon
        List<EventDay> events = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        events.add(new EventDay(calendar, R.drawable.sample_icon));
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setEvents(events);

        //click handling
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                Calendar clickedDayCalendar = eventDay.getCalendar();
            }
        });

        //if you want to select many days
        List<Calendar> selectedDates = calendarView.getSelectedDates();

        calendar = Calendar.getInstance();
        calendar.set(2020, 11, 22);

        try {
            calendarView.setDate(calendar);
        } catch (OutOfDateRangeException e) {
            e.printStackTrace();
        }

        //setting min and max dates
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        calendarView.setMinimumDate(min);
        calendarView.setMaximumDate(max);

        //setting disabled dates
        List<Calendar> calendars = new ArrayList<>();
        calendarView.setDisabledDays(calendars);

        //previous and forward page listeners
        calendarView.setOnPreviousPageChangeListener(new OnCalendarPageChangeListener() {
            @Override
            public void onChange() {

            }
        });
        calendarView.setOnForwardPageChangeListener(new OnCalendarPageChangeListener() {
            @Override
            public void onChange() {

            }
        });


        //getting date picker handling
        listener = new OnSelectDateListener() {
            @Override
            public void onSelect(List<Calendar> calendars) {

            }
        };

        //date picker dialog


        DatePickerBuilder builder = new DatePickerBuilder(this, listener)
                .pickerType(CalendarView.ONE_DAY_PICKER);
        DatePicker datePicker = builder.build();
        datePicker.show();


        //Customization


        // floatin action button
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addnoteintent = new Intent(CalendarActivity.this, AddNoteActivity.class);
                startActivity(addnoteintent);
            }
        });

    }




}

