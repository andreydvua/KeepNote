package com.avdsoft.keeper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AVDSOFT on 10.04.2017;
 * project - 329Keeper;
 */

public class DBHelper extends SQLiteOpenHelper{
    private String nameDB;

    public DBHelper(Context context, String nameDB, int versionDB) {
        super(context, nameDB, null, versionDB);
        this.nameDB = nameDB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + nameDB + "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "desc TEXT, is_notify BOOLEAN, year INTEGER, month INTEGER, day_of_month INTEGER, " +
                "event_time TIME)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
