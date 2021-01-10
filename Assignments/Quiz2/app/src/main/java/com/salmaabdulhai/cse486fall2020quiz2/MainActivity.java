package com.salmaabdulhai.cse486fall2020quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.salmaabdulhai.cse486fall2020quiz2.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button saveItem;
    Button viewDictionary;
    EditText english;
    EditText bangla;
    private ListView listView;
    private TaskAdapter adapter;
    private List<TaskModel> taskList;
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

        taskList = PrefConfig.readListFromPref(this);

        if (taskList == null)
            taskList = new ArrayList<>();


    }

    public void savebanglaTranslation(View view) {
        String result = bangla.getText().toString();
        arrayList.add(result);
        PrefConfig.writeListInPref1(getApplicationContext(),arrayList);
        arrayAdapter.notifyDataSetChanged();

    }


    public void viewDictionary(View view) {

        TaskModel taskModel = new TaskModel(english.getText().toString());
        taskList.add(taskModel);
        PrefConfig.writeListInPref(getApplicationContext(), taskList);
        Intent i = new Intent(MainActivity.this, dictionary.class);
        startActivity(i);
    }
}