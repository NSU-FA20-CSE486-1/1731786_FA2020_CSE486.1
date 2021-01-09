package com.salmaabdulhai.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button saveItem;
    Button viewDictionary;
    EditText english;
    EditText bangla;
    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveItem = (Button) findViewById(R.id.save_btn);
        viewDictionary = (Button) findViewById(R.id.dictionary_btn);
        english =(EditText) findViewById(R.id.edittext_line_1);
        bangla = (EditText) findViewById(R.id.edittext_line_2);
        listView = (ListView) findViewById(R.id.ListViewId);
        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);



    }

    public void savebanglaTranslation(View view) {
        String result = bangla.getText().toString();
        arrayList.add(result);
        arrayAdapter.notifyDataSetChanged();
        saveData();
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString("task list", json);
        editor.apply();
    }

    



    public void viewDictionary(View view) {
    }
}