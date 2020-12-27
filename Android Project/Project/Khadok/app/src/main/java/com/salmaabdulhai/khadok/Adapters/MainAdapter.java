package com.salmaabdulhai.khadok.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salmaabdulhai.khadok.Models.MainModel;
import com.salmaabdulhai.khadok.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    ArrayList <MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflate layout
        View view = LayoutInflater.from(context).inflate(R.layout.sample_customer_dashboard, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        //data bind
        final MainModel model = list.get(position);
        holder.foodImage.setImageResource(model.getImage());
        holder.foodName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());


    }

    @Override
    public int getItemCount() {
        return list.size();
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
