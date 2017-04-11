package com.avdsoft.keeper;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.avdsoft.keeper.models.TaskModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by AVDSOFT on 05.04.2017;
 * project - 329Keeper;
 */

public class CustomAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<TaskModel> tasks = new ArrayList<>();
    private DBHelper dbHelper;
    private ContentValues mCV;
    private SQLiteDatabase mDB;
    private final String NAME_DB = "events";

    public CustomAdapter(Context context, List<TaskModel> taskModelList, DBHelper dbHelper) {
        this.context = context;
        tasks = taskModelList;
        this.dbHelper = dbHelper;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        for (int i = 0; i < 24; i++) {
//            tasks.add(new TaskModel(i+" : 00 "," test_" + i));
//        }
    }
    private void dataAdd(String description, Boolean is_notify, int year, int month, int day_of_month,
                         float event_time) {
        mCV = new ContentValues();
        mCV.put("desc", description);
        mCV.put("is_notify", is_notify);
        mCV.put("year", year);
        mCV.put("month", month);
        mCV.put("day_of_month", day_of_month);
        mCV.put("event_time", event_time);
        mDB = dbHelper.getWritableDatabase();
        mDB.insert(NAME_DB, null, mCV);
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.style_list_item, parent, false);
        TextView time = (TextView) convertView.findViewById(R.id.item_time);
        TextView task = (TextView) convertView.findViewById(R.id.item_task);
        time.setText(tasks.get(position).getDate());
        task.setText(tasks.get(position).getTask());

        convertView.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        LayoutInflater alertInflater = LayoutInflater.from(context);
        View alertView = alertInflater.inflate(R.layout.style_alert, null);
        final Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(2017,4,13);

        final EditText descr_ET = (EditText) alertView.findViewById(R.id.alert_ET);
        final CheckBox isNotify_ChBox = (CheckBox) alertView.findViewById(R.id.alert_ChBox);

        new AlertDialog.Builder(context)
                .setView(alertView)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!TextUtils.isEmpty(descr_ET.getText())){
                            dataAdd(descr_ET.getText().toString(), isNotify_ChBox.isChecked(),
                                    mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                                    mCalendar.get(Calendar.DAY_OF_MONTH), 13f);
                        }
                        dialog.dismiss();
                    }
                }).show();

    }

}
