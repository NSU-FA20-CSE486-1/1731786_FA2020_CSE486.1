package com.salmaabdulhai.khadok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {


    EditText logInNumber, loginPass;
    Button logInBtn;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        logInNumber = (EditText) findViewById(R.id.mobile_login);
        loginPass = (EditText) findViewById(R.id.pass_logIn);
        logInBtn = (Button) findViewById(R.id.login_btn);
        signup = (TextView) findViewById(R.id.noAccountSignup);


        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mobileUser = logInNumber.getText().toString();
                String newPassword = loginPass.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String userMobile = preferences.getString("mobileUser", "");
                String pass = preferences.getString("newPassword", "");

                if ((!mobileUser.equals(userMobile))|| (!newPassword.equals(pass))) {
                    Toast.makeText(LogIn.this, "Wrong username or password. Try again ", Toast.LENGTH_SHORT).show();
                }

                else {


                    Intent mainActivity = new Intent(LogIn.this, MainActivity.class);
                    startActivity(mainActivity);
                }
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(LogIn.this, RegistrationActivity.class);
                startActivity(registerScreen);
            }
        });


    }
}