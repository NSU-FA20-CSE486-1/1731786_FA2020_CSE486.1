package com.salmaabdulhai.khadok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salmaabdulhai.khadok.Adapters.CustomerOrderAdapter;
import com.salmaabdulhai.khadok.Models.CustomerOrderModel;


import java.util.ArrayList;

public class CustomerOrderFragment extends Fragment {

    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customer_order_fragment, container,false);
        recyclerView = view.findViewById(R.id.orderedRecyclerView);


        DBHelper helper = new DBHelper(getContext());
        ArrayList<CustomerOrderModel> list = helper.getOrders();


        CustomerOrderAdapter adapter = new CustomerOrderAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
       recyclerView.setLayoutManager(layoutManager);

        return view;

    }
}




















