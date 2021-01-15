package com.salmaabdulhai.khadok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.salmaabdulhai.khadok.Models.fooditemModel;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class AddFoodItemsFrag extends Fragment{

        EditText foodname, foodprice, foodcategory, fooddescription;
        Button submitbtn, uploadimage;
    private List<fooditemModel> fooditemModelList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_food_items_frag, container,false);
        setHasOptionsMenu(true);

        foodname = (EditText) view.findViewById(R.id.itemName);
        foodprice = (EditText) view.findViewById(R.id.itemPrice);
        foodcategory = (EditText) view.findViewById(R.id.FoodCategory);
        fooddescription = (EditText) view.findViewById(R.id.itemDetail);
        submitbtn= (Button) view.findViewById(R.id.itemSubmitBtn);



        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fooditemModel fooditemModel = new fooditemModel(foodname.getText().toString(), foodprice.getText().toString(), foodcategory.getText().toString(), fooddescription.getText().toString());
                fooditemModelList.add(fooditemModel);
                save();
                Fragment fragment = new Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new chef_dashboard());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void save() {

        //in fragment direct getSharedpreference didnot work so i have used this.getActivity.getSharedPreference
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(fooditemModelList);
        editor.putString("task list", json);
        editor.apply();
    }

    // to remove the menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}