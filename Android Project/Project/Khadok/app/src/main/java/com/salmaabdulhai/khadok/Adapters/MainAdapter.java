package com.salmaabdulhai.khadok.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salmaabdulhai.khadok.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName, price, description;


        public viewholder(@NonNull View itemView) {
            super(itemView);

            foodImage = (ImageView) itemView.findViewById(R.id.food_image);
            foodName = (TextView) itemView.findViewById(R.id.foodName);
            price = (TextView) itemView.findViewById(R.id.price_tv);
            description = (TextView) itemView.findViewById(R.id.food_description);

        }
    }

    ;
}
