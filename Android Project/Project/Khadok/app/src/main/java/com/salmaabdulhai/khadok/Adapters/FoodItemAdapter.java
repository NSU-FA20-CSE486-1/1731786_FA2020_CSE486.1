package com.salmaabdulhai.khadok.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salmaabdulhai.khadok.Models.FooditemModel;
import com.salmaabdulhai.khadok.R;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.viewHolder> {


    List<FooditemModel> list;
    Context context;

    public FoodItemAdapter(List<FooditemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setTaskModelList(List<FooditemModel> list) {
        this.list = list;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_add_food_items, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final FooditemModel model = list.get(position);
        //holder.addFoodImage.setImageResource(model.getAddimage());
        holder.addorderedPrice.setText(model.getAddprice());
        holder.addorderedFoodName.setText(model.getAddname());
        holder.adddescription.setText(model.getAdddescription());
        holder.foodcategory.setText(model.getFoodcategory());

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView addFoodImage;
        TextView addorderedPrice, addorderedFoodName, foodcategory, adddescription;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            //addFoodImage = (ImageView) itemView.findViewById(R.id.addImageView);
            addorderedPrice = (TextView) itemView.findViewById(R.id.addFoodPrice);
            adddescription = (TextView) itemView.findViewById(R.id.addDescription);
            addorderedFoodName = (TextView) itemView.findViewById(R.id.addFoodname);
            foodcategory = (TextView) itemView.findViewById(R.id.addItemCategory);

        }


    }
}
