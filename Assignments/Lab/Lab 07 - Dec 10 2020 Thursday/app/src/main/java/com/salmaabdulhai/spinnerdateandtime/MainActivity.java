package com.salmaabdulhai.spinnerdateandtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.Menu;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerMonth, spinnerYear, spinnerDay, spinnerHour, spinnerMinute, spinnerAPm;
    Button displayDate, displayTime;
    String[] months;
    String[] amPm;
    //String textTosend;



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

        spinnerDay.setOnItemSelectedListener(this);
        spinnerMonth.setOnItemSelectedListener(this);
        spinnerYear.setOnItemSelectedListener(this);
        spinnerHour.setOnItemSelectedListener(this);
        spinnerMinute.setOnItemSelectedListener(this);
        spinnerAPm.setOnItemSelectedListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.confirm) {
            Intent intent = new Intent(MainActivity.this, ConfirmedDateAndTime.class);
            String month = spinnerMonth.getSelectedItem().toString();
            String year = spinnerYear.getSelectedItem().toString();
            String day = spinnerDay.getSelectedItem().toString();
            String hour = spinnerHour.getSelectedItem().toString();
            String minute = spinnerMinute.getSelectedItem().toString();
            String amPm = spinnerAPm.getSelectedItem().toString();
            intent.putExtra("Day", day);
            intent.putExtra("Month", month);
            intent.putExtra("Year", year);
            intent.putExtra("Hour", hour);
            intent.putExtra("Minute", minute);
            intent.putExtra("AmPm", amPm);
            startActivity(intent);
            return  false;
        }

            return super.onOptionsItemSelected(item);

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
    

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.dspinner){
            String selectedDay = parent.getSelectedItem().toString();
            Toast.makeText(this, "Selected: "+ selectedDay, Toast.LENGTH_SHORT).show();
        }

        else if (parent.getId() == R.id.mspinner){
            String selectedMonth = parent.getSelectedItem().toString();
            Toast.makeText(this, "Selected: "+ selectedMonth, Toast.LENGTH_SHORT).show();


        }

        else if (parent.getId() == R.id.yspinner){
            String selectedYear = parent.getSelectedItem().toString();
            Toast.makeText(this, "Selected: "+ selectedYear, Toast.LENGTH_SHORT).show();

        }

        else if (parent.getId() == R.id.hspinner){
            String selectedHour = parent.getSelectedItem().toString();
            Toast.makeText(this, "Selected: "+ selectedHour, Toast.LENGTH_SHORT).show();

        }

        else if (parent.getId() == R.id.minspinner){
            String selectedMinute = parent.getSelectedItem().toString();
            Toast.makeText(this, "Selected: "+ selectedMinute, Toast.LENGTH_SHORT).show();


        }
        else if (parent.getId() == R.id.spinnerAMPM){
            String selectedAmpm = parent.getSelectedItem().toString();
            Toast.makeText(this, "Selected: "+ selectedAmpm, Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}