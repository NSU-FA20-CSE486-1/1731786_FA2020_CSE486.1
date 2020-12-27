package com.salmaabdulhai.khadok.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salmaabdulhai.khadok.Models.CustomerOrderModel;
import com.salmaabdulhai.khadok.R;

import java.util.ArrayList;

public class CustomerOrderAdapter extends RecyclerView.Adapter<CustomerOrderAdapter.viewHolder> {


    ArrayList <CustomerOrderModel> list;
    Context context;

    public CustomerOrderAdapter(ArrayList<CustomerOrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_customer_orders, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final CustomerOrderModel model = list.get(position);
        holder.orderedFoodImage.setImageResource(model.getOrderedImage());
        holder.orderedPrice.setText(model.getPrice());
        holder.orderedFoodName.setText(model.getOrderedFood());
        holder.orderedNumber.setText(model.getOrderNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView orderedFoodImage;
        TextView orderedPrice, orderedFoodName, orderedNumber;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderedFoodImage = (ImageView) itemView.findViewById(R.id.orderedImageView);
            orderedPrice = (TextView) itemView.findViewById(R.id.orderedFoodPrice);
            orderedNumber = (TextView) itemView.findViewById(R.id.orderID);
            orderedFoodName = (TextView) itemView.findViewById(R.id.orderedFoodname);
        }


    }
}
