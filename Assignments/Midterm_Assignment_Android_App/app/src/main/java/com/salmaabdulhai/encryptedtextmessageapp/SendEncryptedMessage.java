package com.salmaabdulhai.encryptedtextmessageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class SendEncryptedMessage extends AppCompatActivity {
    TextView encryptedtText;
    String message, key, text, phoneNumber;
    Button send_btn;
    EditText decrypted_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_encrypted_message);
        encryptedtText= (TextView) findViewById(R.id.textView);
        send_btn = (Button) findViewById(R.id.button2);
        decrypted_text = (EditText) findViewById(R.id.decrypt_et);
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

    public void decrypt(View view) {
        try {

            key = decrypted_text.getText().toString();
            text =getIntent().getStringExtra("Text");

            String decrypted = AESCrypt.decrypt(key, text);
            ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("label",decrypted);
            clipboardManager.setPrimaryClip(clipData);
            decrypted_text.setText(decrypted);





        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}