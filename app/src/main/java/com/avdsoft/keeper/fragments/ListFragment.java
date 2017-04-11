package com.avdsoft.keeper.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.avdsoft.keeper.CustomAdapter;
import com.avdsoft.keeper.DBHelper;
import com.avdsoft.keeper.R;
import com.avdsoft.keeper.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AVDSOFT on 05.04.2017;
 * project - 329Keeper;
 */

public class ListFragment extends Fragment {
    private ListView list_items;
    private final String NAME_DB = "events";
    private DBHelper dbHelper;
    private SQLiteDatabase mDB;
    private int year, month, dayOfMonth;

    private List<TaskModel> getTaskList(int year, int month, int dayOfMonth) {
        List<TaskModel> tasksAList = new ArrayList<>();
        mDB = dbHelper.getReadableDatabase();
        Cursor c = mDB.query(NAME_DB, new String[]{"desc", "is_notify", "event_time"},
                "day_of_month=?", new String[]{String.valueOf(dayOfMonth)}, null, null, null);
        if (c.moveToFirst()) {
            int descrColIndex = c.getColumnIndex("desc");
            int isNotifyColIndex = c.getColumnIndex("is_notify");
            int eventTimeColIndex = c.getColumnIndex("event_time");
            do {
                TaskModel task = new TaskModel(
                        String.valueOf(c.getFloat(eventTimeColIndex)),
                        c.getString(descrColIndex),
                        c.getInt(isNotifyColIndex) == 1
                );
                tasksAList.add(task);
            } while (c.moveToNext());
            c.close();
        }
        return tasksAList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper = new DBHelper(getActivity(), NAME_DB, 1);
        list_items = (ListView) view.findViewById(R.id.list_items);
        list_items.setAdapter(new CustomAdapter(getActivity(), getTaskList(2017, 4, 13), dbHelper));
    }
}
