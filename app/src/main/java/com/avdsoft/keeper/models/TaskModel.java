package com.avdsoft.keeper.models;

import java.util.Date;

/**
 * Created by AVDSOFT on 05.04.2017;
 * project - 329Keeper;
 */

public class TaskModel {
    private String date;
    private String task;
    private boolean isNotify;

    public TaskModel(String time, String task, boolean isNotify) {
        this.date = time;
        this.task = task;
        this.isNotify = isNotify;
    }

    public String getDate() {
        return date;
    }

    public String getTask() {
        return task;
    }

    public boolean isNotify() {
        return isNotify;
    }
}
