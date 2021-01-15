package com.salmaabdulhai.khadok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.salmaabdulhai.khadok.Adapters.CustomerOrderAdapter;
import com.salmaabdulhai.khadok.Adapters.foodItemAdapter;
import com.salmaabdulhai.khadok.Models.fooditemModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class chef_dashboard extends Fragment{

    Button addFoodBtn;
    private List<fooditemModel> fooditemModelList;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chef_dashboard_frag, container,false);
        loadData();

        setHasOptionsMenu(true);
        recyclerView = view.findViewById(R.id.chefsFood);
        recyclerView.setHasFixedSize(true);
        addFoodBtn = view.findViewById(R.id.dash_add_item);
        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new AddFoodItemsFrag());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        foodItemAdapter foodItemAdapter = new foodItemAdapter(fooditemModelList, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(foodItemAdapter);
        //foodItemAdapter.notifyItemInserted(fooditemModelList.size());






        return view;

    }




    private void loadData() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<fooditemModel>>() {}.getType();
        fooditemModelList = gson.fromJson(json, type);
        if (fooditemModelList == null) {
            fooditemModelList = new ArrayList<>();
        }
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}