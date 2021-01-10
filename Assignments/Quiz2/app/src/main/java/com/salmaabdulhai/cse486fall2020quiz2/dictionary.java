package com.salmaabdulhai.cse486fall2020quiz2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.salmaabdulhai.cse486fall2020quiz2.R;

import java.util.List;

public class dictionary extends AppCompatActivity {

    private RecyclerView reccyclerView;
    private TaskAdapter adapter;

    private List<TaskModel> taskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        reccyclerView = findViewById(R.id.recyclerView);
        taskList = PrefConfig.readListFromPref(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        reccyclerView.setLayoutManager(layoutManager);
        reccyclerView.setHasFixedSize(true);
        adapter = new TaskAdapter(getApplicationContext(), taskList);
        reccyclerView.setAdapter(adapter);


    }


}