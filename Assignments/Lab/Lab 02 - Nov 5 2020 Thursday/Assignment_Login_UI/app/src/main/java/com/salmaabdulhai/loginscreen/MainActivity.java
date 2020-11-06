package com.salmaabdulhai.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Variables declaration

    private EditText name;
    private EditText password;
    private TextView attempts;
    private Button login;
    private int counter =5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Variable assignment

        name= (EditText)findViewById(R.id.userNameEditText);
        password= (EditText)findViewById(R.id.editTextPassword);
        attempts= (TextView)findViewById(R.id.incorrectInfo);
        login= (Button)findViewById(R.id.loginButton);
        attempts.setText("No of attempts remaining: 5");

        //We need the method validationCheck to work when
        // the login button is clicked so we need OnClickListener

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validationCheck(name.getText().toString(), password.getText().toString());
            }
        });
    }


    //checks the username and password
    private void validationCheck(String username, String passwordEntered){
        if((username.equals("admin")) && (passwordEntered.equals("1234"))){
            //if condition matches, the user will have an access to the app (second activity)
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        //if it doesn't match, decrement the number of 5 wrong attempts
        else {
            counter--;
            attempts.setText("No of attempts remaining: " + String.valueOf(counter));
            if(counter == 0){
                //the user will not be able to log in after 5 wrong attempts
                login.setEnabled(false);
            }
        }




    }
}