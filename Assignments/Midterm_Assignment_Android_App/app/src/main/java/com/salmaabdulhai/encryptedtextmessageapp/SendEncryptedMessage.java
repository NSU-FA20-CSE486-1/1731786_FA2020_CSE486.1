package com.salmaabdulhai.encryptedtextmessageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SendEncryptedMessage extends AppCompatActivity {
    TextView encryptedtText;
    String message, phoneNumber;
    Button send_btn;
    EditText decrypted_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_encrypted_message);
        encryptedtText= (TextView) findViewById(R.id.textView);
        send_btn = (Button) findViewById(R.id.button2);
        decrypted_text = (EditText) findViewById(R.id.garbeledText);
        message = getIntent().getStringExtra("Encrypted text");
        encryptedtText.setText(message);

    }

    public void openSmsApp(View view) {
        phoneNumber = "sms:" + getIntent().getStringExtra("Phone number");
        Uri uri = Uri.parse(phoneNumber);
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", encryptedtText.getText().toString());
        startActivity(it);
    }


}