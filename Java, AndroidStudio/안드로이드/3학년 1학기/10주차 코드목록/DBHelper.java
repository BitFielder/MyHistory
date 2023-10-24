package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    int code = 100;
    static String DBNAME = "PRODUCTDB";
    String TBLNAME = "productsTBL";
    // 데이터베이스, 테이블 이름 선언

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
        this.context = context;
    }
    // 클래스 불러올 시 생성자입니다.

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBLNAME +
                "(_code TEXT PRIMARY KEY, name TEXT, price FLOAT);";
        db.execSQL(sql);
        // TEXT로 하기 때문에 AUTOINCREMENT는 제외했습니다.
        // INDEX를 이용해서 CD-0100 형식으로 구현하는건 어려워서 일단 제외했습니다.

        db.beginTransaction();
        try {
            insertData();
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            db.endTransaction();
        }
    }
    // 앱 실행 시 구동되는 코드

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE " + TBLNAME + ";";
        db.execSQL(sql);
        sql = "DROP INDEX name;";
        db.execSQL(sql);
        onCreate(db);
    }
    // 데이터테이블 수정 시 재설정용으로 테이블, 인덱스 제거

    public void insertData() {
        SQLiteDatabase database = getWritableDatabase();
        database.beginTransaction();
        String sql = "INSERT INTO " + TBLNAME + " (_code, name, price) VALUES(?, ?, ?);";
        String[] name = {"Cookie", "Candy", "Cake"};
        double[] price = {150.0, 80.5, 360.0};
        try {
            SQLiteStatement statement = database.compileStatement(sql);
            for (int i = 0; i < name.length; i++) {
                statement.bindString(1, "CD-0" + String.valueOf(code++));
                // 인덱스를 쓰기 어려워서 일단 이렇게라도 했습니다..
                statement.bindString(2, name[i]);
                statement.bindDouble(3, price[i]);
                statement.executeInsert();
            }
            database.setTransactionSuccessful();
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            database.endTransaction();
        }
    }
    // 데이터 레코드 추가

    public Cursor search() {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "SELECT * FROM " + TBLNAME + ";";
        Cursor cursor = database.rawQuery(sql, null);

        return cursor;
    }
    // 검색입니다.

    public void deleteData1() {
        SQLiteDatabase database = getReadableDatabase();
        String sql = "SELECT * FROM " + TBLNAME + ";";
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String del = cursor.getString(cursor.getColumnIndex("_code"));
            sql = "DELETE FROM " + TBLNAME + " WHERE _code = '" + del+"';";
            database.execSQL(sql);
        }
        cursor.close();
    }
    // 레코드를 하나 제거합니다.

    public void deleteData2() {
        SQLiteDatabase database = getReadableDatabase();
        database.beginTransaction();
        try {
            String sql = "SELECT * FROM " + TBLNAME + ";";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String del = cursor.getString(cursor.getColumnIndex("_code"));
                sql = "DELETE FROM " + TBLNAME + " WHERE _code = ?";
                SQLiteStatement statement = database.compileStatement(sql);
                statement.bindString(1, del);
                statement.executeUpdateDelete();
            }
            cursor.close();

            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }
    // 레코드를 하나 제거합니다. 이번엔 statement를 사용합니다.
    public void deleteData3() {
        //여긴 뭐넣어야할 지 ppt에 없어서 일단 비워놨습니다.
    }

    public void deleteAll() {
        SQLiteDatabase database = getReadableDatabase();
        database.beginTransaction();
        try {
            String sql = "DELETE FROM " + TBLNAME + ";";
            SQLiteStatement statement = database.compileStatement(sql);
            statement.executeUpdateDelete();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }
    // 모든 레코드를 제거합니다.

    public void update1() {
        SQLiteDatabase database = getWritableDatabase();
        database.beginTransaction();
        try {
            String sql = "SELECT * FROM productsTBL;";
            Cursor cursor = database.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                String cd = cursor.getString(0);
                String name = cursor.getString(1);
                float price = 2000;
                database.execSQL("REPLACE INTO productsTBL (_code, name, price) VALUES (?, ?, ?);", new Object[]{cd, name, price});
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }
    // 레코드에 있는 모든 가격을 2000으로 수정합니다.

    public void update2() {
        SQLiteDatabase database = getWritableDatabase();
        database.beginTransaction();
        try {
            String sql = "UPDATE productsTBL SET price = 3000;";
            SQLiteStatement statement = database.compileStatement(sql);
            statement.execute();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }
    // 레코드에 있는 가격을 3000으로 수정합니다.
    // 개인적으론 REPLACE보단 UPDATE가 훨씬 효율적인 것 같습니다.
}