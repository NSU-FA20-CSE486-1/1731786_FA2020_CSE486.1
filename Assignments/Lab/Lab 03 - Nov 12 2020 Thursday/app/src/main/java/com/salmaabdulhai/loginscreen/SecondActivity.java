package com.salmaabdulhai.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView message;
    String message2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        message = (TextView)findViewById(R.id.textViewSecondActivity);
        message2 = getIntent().getStringExtra("Keyname");
        message.setText("Hi, " +message2+ ", Welcome back!");
    }
}