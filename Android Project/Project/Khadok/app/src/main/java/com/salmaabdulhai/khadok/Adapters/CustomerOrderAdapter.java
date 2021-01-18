package com.salmaabdulhai.khadok.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salmaabdulhai.khadok.DBHelper;
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
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DBHelper dbHelper = new DBHelper(context);
                new AlertDialog.Builder(context).setTitle("Delete")
                        .setIcon(R.drawable.ic_remove).setMessage("Are you sure you want to delete this order?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbHelper.deleteOrder(model.getOrderNumber());
                                Toast.makeText(context, "Your order has been removed1", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                }).show();



                
                /*if(dbHelper.deleteOrder(model.getOrderNumber()) > 0){
                    Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(context, "nooo", Toast.LENGTH_SHORT).show();
                }*/

                return false;
            }
        });

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
