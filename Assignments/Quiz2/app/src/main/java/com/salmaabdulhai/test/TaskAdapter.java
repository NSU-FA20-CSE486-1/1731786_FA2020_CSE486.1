package com.salmaabdulhai.test;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.Holder> {
    private Context context;
    private List<TaskModel> taskModelList;
    Dialog myDialogue;

    public TaskAdapter(Context context, List<TaskModel> taskModelList) {
        this.context = context;
        this.taskModelList = taskModelList;
        //Collections.reverse(taskModelList);
    }

    public void setTaskModelList(List<TaskModel> taskModelList) {
        this.taskModelList = taskModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.english_words, parent, false);
        Holder vHolder= new Holder(v);




        //myDialogue= new Dialog(context);
        //myDialogue.setContentView(R.layout.dialog_message);
        //myDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.txtTaskName.setText(taskModelList.get(position).getTaskName());
    }

    @Override
    public int getItemCount() {
        return taskModelList != null ? taskModelList.size() : 0;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtTaskName;
        private LinearLayout layoutid;
        public Holder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTaskName = itemView.findViewById(R.id.txt_task_name);
            layoutid = (LinearLayout) itemView.findViewById(R.id.popupid);
        }

        @Override
        public void onClick(View v) {
            TaskModel soemthing = taskModelList.get(getPosition());
            myDialogue= new Dialog(context);
            myDialogue.setContentView(R.layout.dialog_message);
            myDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            TextView ss = (TextView) myDialogue.findViewById(R.id.popupMessage);
            ss.setText(soemthing.getTaskName());

            myDialogue.show();

        }
    }

}