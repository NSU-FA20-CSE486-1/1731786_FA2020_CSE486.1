package com.salmaabdulhai.khadok;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.salmaabdulhai.khadok.Adapters.MainAdapter;
import com.salmaabdulhai.khadok.Models.MainModel;
import com.salmaabdulhai.khadok.databinding.ActivityCustomerHomechefFoodItemsBinding;

import java.util.ArrayList;

public class customerHomechefFoodItems extends AppCompatActivity {

    ActivityCustomerHomechefFoodItemsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerHomechefFoodItemsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.fried_rice, "Fried rice", "255", "with tomatoes and green chillies"));
        list.add(new MainModel(R.drawable.shrimp_salad, "Fried shrimps", "50", "with magic white sauce and fries"));
        list.add(new MainModel(R.drawable.kacchi_biryani, "Kacchi", "780", "mutton with salad and free drinks"));
        list.add(new MainModel(R.drawable.noodles, "Noodles", "5", "Meaty mushrooms and magic white sauce"));
        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);




    }


}

