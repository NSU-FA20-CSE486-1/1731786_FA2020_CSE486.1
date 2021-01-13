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

import com.salmaabdulhai.khadok.Adapters.chefOfferedFoodItemsAdapter;
import com.salmaabdulhai.khadok.Models.chefOfferedFoodItems;

import java.util.ArrayList;

public class offered_food_items_fragment extends Fragment {

    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offered_food_items_fragment, container,false);
        recyclerView = view.findViewById(R.id.offeredItemsFrag);

        ArrayList<chefOfferedFoodItems> list = new ArrayList<>();
        list.add(new chefOfferedFoodItems(R.drawable.fried_rice, "Fried rice", "255", "with tomatoes and green chillies"));
        list.add(new chefOfferedFoodItems(R.drawable.shrimp_salad, "Fried shrimps", "50", "with magic white sauce and fries"));
        list.add(new chefOfferedFoodItems(R.drawable.kacchi_biryani, "Kacchi", "780", "mutton with salad and free drinks"));
        list.add(new chefOfferedFoodItems(R.drawable.noodles, "Noodles", "5", "Meaty mushrooms and magic white sauce"));
        chefOfferedFoodItemsAdapter adapter = new chefOfferedFoodItemsAdapter (list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }
}
