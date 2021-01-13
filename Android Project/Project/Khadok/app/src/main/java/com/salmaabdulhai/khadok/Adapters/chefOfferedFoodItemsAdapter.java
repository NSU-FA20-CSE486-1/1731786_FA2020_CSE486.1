package com.salmaabdulhai.khadok.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salmaabdulhai.khadok.Models.MainModel;
import com.salmaabdulhai.khadok.Models.chefOfferedFoodItems;
import com.salmaabdulhai.khadok.R;

        import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

        import com.salmaabdulhai.khadok.Models.MainModel;
        import com.salmaabdulhai.khadok.R;
import com.salmaabdulhai.khadok.offered_food_items_fragment;

import java.util.ArrayList;

public class chefOfferedFoodItemsAdapter extends RecyclerView.Adapter<chefOfferedFoodItemsAdapter.viewholder> {

    ArrayList<chefOfferedFoodItems> list;
    Context context;

    public chefOfferedFoodItemsAdapter(ArrayList<chefOfferedFoodItems> list, Context context) {
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
        final chefOfferedFoodItems model = list.get(position);
        holder.offfoodImage.setImageResource(model.getOfferedFoodImage());
        holder.offfoodName.setText(model.getOfferedFoodName());
        holder.offprice.setText(model.getOfferedFoodPrice());
        holder.offdescription.setText(model.getOfferedFoodDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new Fragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new offered_food_items_fragment()).addToBackStack(null).commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView offfoodImage;
        TextView offfoodName, offprice, offdescription;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            offfoodImage = (ImageView) itemView.findViewById(R.id.food_image);
            offfoodName = (TextView) itemView.findViewById(R.id.foodName);
            offprice = (TextView) itemView.findViewById(R.id.price_tv);
            offdescription = (TextView) itemView.findViewById(R.id.food_description);
        }
    }
    ;
}