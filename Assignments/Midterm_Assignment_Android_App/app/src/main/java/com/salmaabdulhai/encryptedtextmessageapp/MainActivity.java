package com.salmaabdulhai.encryptedtextmessageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {
    EditText enterText_et;
    EditText enterKey_et;
    EditText phoneNumber;
    Button encrypt_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterKey_et = (EditText) findViewById(R.id.EnterKey_ev);
        enterText_et = (EditText) findViewById(R.id.EnterText_ev);
        phoneNumber = (EditText) findViewById(R.id.EnterPhone_ev);
        encrypt_btn = (Button) findViewById(R.id.button);



    }

    public void encrypt(View view) {
        try {
            String encrypted = AESCrypt.encrypt(enterKey_et.getText().toString(), enterText_et.getText().toString());
            ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("label",encrypted);
            clipboardManager.setPrimaryClip(clipData);
            //String key = enterKey_et.getText().toString();
            String text = enterText_et.getText().toString();
            String concat = enterKey_et.getText().toString() + " " + encrypted;
            String text_to_send = concat;
            Intent it = new Intent(MainActivity.this,SendEncryptedMessage.class);
            it.putExtra("Encrypted text", text_to_send);
            //it.putExtra("Key", key);
            it.putExtra("Text", text);
            it.putExtra("Phone number", phoneNumber.getText().toString() );
            startActivity(it);



        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

    }
}