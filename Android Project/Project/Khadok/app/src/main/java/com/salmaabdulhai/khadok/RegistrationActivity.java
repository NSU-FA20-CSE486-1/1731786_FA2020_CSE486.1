package com.salmaabdulhai.khadok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText mobileReg, password, confirmPassword;
    Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mobileReg = (EditText) findViewById(R.id.mobile_reg);
        password = (EditText) findViewById(R.id.pass_reg);
        confirmPassword = (EditText) findViewById(R.id.retypePass_reg);
        regBtn = (Button) findViewById(R.id.signup_btn);



        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String mobileUser = mobileReg.getText().toString();
                String newPassword = password.getText().toString();
                String retypePass = confirmPassword.getText().toString();

                if (!retypePass.equals(newPassword)) {
                    Toast.makeText(RegistrationActivity.this, "Wrong! Retype your Password.", Toast.LENGTH_SHORT).show();
                }



                else {

                    SharedPreferences.Editor editor = preferences.edit();

                    //stores 2 new instances of sharedprefs. Both the mobile number and password's keys are the same as the input.
                    editor.putString("mobileUser", mobileUser);
                    editor.commit();
                    editor.putString("newPassword", newPassword);
                    editor.commit();


                    Intent loginScreen = new Intent(RegistrationActivity.this, LogIn.class);
                    startActivity(loginScreen);
                }
            }
        });

    }
}