package com.salmaabdulhai.khadok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.salmaabdulhai.khadok.Adapters.FoodItemAdapter;

public class OrderDetailFrag extends Fragment {


    TextView name, price, desc;
    ImageView image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private Bundle bundle;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.bundle = getArguments();
        if (bundle != null) {
            String foodname = bundle.getString("foodname");
            String foodprice = bundle.getString("foodprice");
            String fooddes = bundle.getString("fooddes");
            int foodimage = bundle.getInt("foodimage");

            name.setText(foodname);
            price.setText(foodprice);
            desc.setText(fooddes);
            image.setImageResource(foodimage);
        }

        else Toast.makeText(getContext(), "ggggg", Toast.LENGTH_SHORT).show();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.customer_order_detail_frag, container, false);

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        name = view.findViewById(R.id.detail_foodName);
        price = view.findViewById(R.id.totalPrice);
        desc = view.findViewById(R.id.detailDescription);
        image = view.findViewById(R.id.detailsImage);
    }
}