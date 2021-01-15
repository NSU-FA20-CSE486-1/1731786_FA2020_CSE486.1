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
import com.salmaabdulhai.khadok.Models.fooditemModel;
import com.salmaabdulhai.khadok.R;

import java.util.ArrayList;

public class foodItemAdapter extends RecyclerView.Adapter<foodItemAdapter.viewHolder> {


    ArrayList<fooditemModel> list;
    Context context;

    public foodItemAdapter(ArrayList<fooditemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.chef_dashboard_frag, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final fooditemModel model = list.get(position);
        holder.addFoodImage.setImageResource(model.getAddimage());
        holder.addorderedPrice.setText(model.getAddprice());
        holder.addorderedFoodName.setText(model.getAddname());
        holder.adddescription.setText(model.getAdddescription());
        holder.foodcategory.setText(model.getFoodcategory());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView addFoodImage;
        TextView addorderedPrice, addorderedFoodName, foodcategory, adddescription;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            addFoodImage = (ImageView) itemView.findViewById(R.id.addImageView);
            addorderedPrice = (TextView) itemView.findViewById(R.id.addFoodPrice);
            adddescription = (TextView) itemView.findViewById(R.id.addDescription);
            addorderedFoodName = (TextView) itemView.findViewById(R.id.addFoodname);
            foodcategory = (TextView) itemView.findViewById(R.id.addItemCategory);

        }


    }
}
