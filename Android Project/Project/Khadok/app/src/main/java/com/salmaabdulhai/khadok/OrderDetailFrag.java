package com.salmaabdulhai.khadok;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    Button placeOrderbtn;

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
            final String foodname = bundle.getString("foodname");
            final String foodprice = bundle.getString("foodprice");
            final String fooddes = bundle.getString("fooddes");
           final int foodimage = bundle.getInt("foodimage");

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
        placeOrderbtn= view.findViewById(R.id.placeOrder);

        DBHelper dbHelper = new DBHelper(getContext());

        placeOrderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted = dbHelper.insertOrder(bundle.getString("foodprice"), bundle.getInt("foodimage"),
                        bundle.getString("fooddes"),
                        bundle.getString("foodname")
                      );
               if(isInserted){
                   Toast.makeText(getContext(), "Data Success", Toast.LENGTH_SHORT).show();}


               else {
                   Toast.makeText(getContext(), "Error inserting order", Toast.LENGTH_SHORT).show();}
            }
        });
    }
}