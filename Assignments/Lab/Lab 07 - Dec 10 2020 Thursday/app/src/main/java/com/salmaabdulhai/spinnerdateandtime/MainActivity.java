package com.salmaabdulhai.spinnerdateandtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerMonth, spinnerYear, spinnerDay, spinnerHour, spinnerMinute, spinnerAPm;
    Button displayDate, displayTime;
    String[] months;
    String[] amPm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerMonth = (Spinner) findViewById(R.id.mspinner);
        spinnerYear = (Spinner) findViewById(R.id.yspinner);
        spinnerDay = (Spinner) findViewById(R.id.dspinner);
        displayDate = (Button) findViewById(R.id.date_display);


        spinnerHour = (Spinner) findViewById(R.id.hspinner);
        spinnerMinute = (Spinner) findViewById(R.id.minspinner);
        spinnerAPm = (Spinner) findViewById(R.id.spinnerAMPM);
        displayTime = (Button) findViewById(R.id.time_display);


        populateSpinnerDay();
        populateSpinnerMonth();
        populateSpinnerYear();
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String month = spinnerMonth.getSelectedItem().toString();
                String year = spinnerYear.getSelectedItem().toString();
                String day = spinnerDay.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, day + "-" + month + "-" + year, Toast.LENGTH_SHORT).show();

            }
        });
        populateSpinnerHour();
        populateSpinnerMinute();
        populateSpinnerAmPm();

        displayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hour = spinnerHour.getSelectedItem().toString();
                String minute = spinnerMinute.getSelectedItem().toString();
                String amPm = spinnerAPm.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, hour + " Hour " + minute + " Minute " + amPm, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void populateSpinnerDay(){
        ArrayAdapter<String> DayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Spinner_day) );
        DayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(DayAdapter);
    }
    private void populateSpinnerYear() {
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Spinner_year) );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);
    }


    private void populateSpinnerMonth(){
        months = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(monthAdapter);
    }






    private void populateSpinnerHour() {
        ArrayAdapter<String> HourAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Spinner_hour) );
        HourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHour.setAdapter(HourAdapter);

    }

    private void populateSpinnerMinute() {
        ArrayAdapter<String> MinuteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Spinner_Minute));
        MinuteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinute.setAdapter(MinuteAdapter);
    }



    private void populateSpinnerAmPm(){
        amPm = new DateFormatSymbols().getAmPmStrings();
        ArrayAdapter<String> amPmAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, amPm);
        amPmAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAPm.setAdapter(amPmAdapter);

    }




}