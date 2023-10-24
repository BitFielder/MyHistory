package com.example.imagejson;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "sawon1.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "sawon";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_SALARY = "salary";
    public static final String COLUMN_IMAGE = "image";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " TEXT PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_SALARY + " INTEGER, " +
                COLUMN_IMAGE + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @SuppressLint("Range")
    public ArrayList<Sawon> getAllSawons() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Sawon> sawons = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Sawon sawon = new Sawon();
            sawon.setId(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
            sawon.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
            sawon.setGender(cursor.getString(cursor.getColumnIndex(COLUMN_GENDER)));
            sawon.setSalary(cursor.getInt(cursor.getColumnIndex(COLUMN_SALARY)));
            sawon.setImage(cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE)));
            sawons.add(sawon);
        }

        cursor.close();
        db.close();

        return sawons;
    }
}
