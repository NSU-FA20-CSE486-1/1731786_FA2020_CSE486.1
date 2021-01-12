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

import com.salmaabdulhai.khadok.Adapters.MainAdapter;
import com.salmaabdulhai.khadok.Models.MainModel;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container,false);
        recyclerView = view.findViewById(R.id.customerchefHomeFrag);

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.fried_rice, "William John", "Food heaven right here"));
        list.add(new MainModel(R.drawable.shrimp_salad, "Food Heaven",  "with magic white sauce and fries as free side dishes!"));
        list.add(new MainModel(R.drawable.kacchi_biryani, "Shimla Mirch",  "Get lost with flavors!"));
        list.add(new MainModel(R.drawable.noodles, "Food Bursts", "Can't think of any more bio!"));
        MainAdapter adapter = new MainAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }
}
