package com.salmaabdulhai.khadok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.salmaabdulhai.khadok.databinding.ActivityCustomerOrderDetailBinding;
import com.salmaabdulhai.khadok.databinding.ActivityMainBinding;

public class customer_order_detail extends AppCompatActivity {

   ActivityCustomerOrderDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerOrderDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}