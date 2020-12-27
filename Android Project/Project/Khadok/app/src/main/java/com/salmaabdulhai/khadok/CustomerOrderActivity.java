package com.salmaabdulhai.khadok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.salmaabdulhai.khadok.Adapters.CustomerOrderAdapter;
import com.salmaabdulhai.khadok.Adapters.MainAdapter;
import com.salmaabdulhai.khadok.Models.CustomerOrderModel;
import com.salmaabdulhai.khadok.Models.MainModel;
import com.salmaabdulhai.khadok.databinding.ActivityCustomerOrderBinding;
import com.salmaabdulhai.khadok.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class CustomerOrderActivity extends AppCompatActivity {

    ActivityCustomerOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<CustomerOrderModel> list = new ArrayList<>();
        list.add(new CustomerOrderModel(R.drawable.kacchi_biryani, "250", "Kacchi Biryani", "k14788523"));
        list.add(new CustomerOrderModel(R.drawable.kacchi_biryani, "250", "Kacchi Biryani", "k14788523"));
        list.add(new CustomerOrderModel(R.drawable.kacchi_biryani, "250", "Kacchi Biryani", "k14788523"));
        list.add(new CustomerOrderModel(R.drawable.kacchi_biryani, "250", "Kacchi Biryani", "k14788523"));
        list.add(new CustomerOrderModel(R.drawable.kacchi_biryani, "250", "Kacchi Biryani", "k14788523"));
        list.add(new CustomerOrderModel(R.drawable.kacchi_biryani, "250", "Kacchi Biryani", "k14788523"));
        list.add(new CustomerOrderModel(R.drawable.kacchi_biryani, "250", "Kacchi Biryani", "k14788523"));
        list.add(new CustomerOrderModel(R.drawable.kacchi_biryani, "250", "Kacchi Biryani", "k14788523"));
        CustomerOrderAdapter adapter = new CustomerOrderAdapter(list, this);
        binding.orderedRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderedRecyclerView.setLayoutManager(layoutManager);

    }
}