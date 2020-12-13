package com.salmaabdulhai.spinnerdateandtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.security.Key;

public class ConfirmedDateAndTime extends AppCompatActivity {

    TextView tv;
    String day, month, year, hour, min, amp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmed_date_and_time);
        tv = (TextView) findViewById(R.id.textView);
        day = getIntent().getStringExtra("Day");
        month = getIntent().getStringExtra("Month");
        year= getIntent().getStringExtra("Year");
        hour= getIntent().getStringExtra("Hour");
        min= getIntent().getStringExtra("Minute");
        amp= getIntent().getStringExtra("AmPm");

        //tv.setText(day);
        tv.setText("The user has selected " + day +" " +month + " "+ year + "\n\nAnd Time " + hour + "-" + min + "-" + amp);

    }
}