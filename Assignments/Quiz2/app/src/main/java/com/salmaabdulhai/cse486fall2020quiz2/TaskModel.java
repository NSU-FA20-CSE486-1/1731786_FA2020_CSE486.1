package com.salmaabdulhai.cse486fall2020quiz2;

import java.io.Serializable;


public class TaskModel implements Serializable{
    private String task_name;


    public TaskModel(String taskName) {
        this.task_name = taskName;

    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTaskName() {
        return task_name;
    }

}