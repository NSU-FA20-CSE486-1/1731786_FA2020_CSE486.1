package com.salmaabdulhai.khadok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salmaabdulhai.khadok.Adapters.FoodItemAdapter;
import com.salmaabdulhai.khadok.AddFoodItemsFrag;
import com.salmaabdulhai.khadok.Models.FooditemModel;
import com.salmaabdulhai.khadok.PrefConfig;
import com.salmaabdulhai.khadok.R;

import java.util.List;

import static java.security.AccessController.getContext;

public class Chef_dashboard extends Fragment {

    Button addFoodBtn;
    private List<FooditemModel> fooditemModelList;
    RecyclerView recyclerView;
    FoodItemAdapter foodItemAdapter;

    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fooditemModelList = PrefConfig.readListFromPref(getContext());
        foodItemAdapter = new FoodItemAdapter(fooditemModelList, getContext());
        foodItemAdapter.setTaskModelList(fooditemModelList);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chef_dashboard_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        recyclerView = view.findViewById(R.id.chefsFood);
        addFoodBtn = view.findViewById(R.id.dash_add_item);

        recyclerView.setHasFixedSize(true);


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


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //      foodItemAdapter = new FoodItemAdapter(fooditemModelList, getContext());
        recyclerView.setAdapter(foodItemAdapter);
        //   foodItemAdapter.notifyItemInserted(fooditemModelList.size());

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

}