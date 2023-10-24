package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DBHelper helper;    // 데이터 헬퍼 클래스 선언입니다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper(MainActivity.this);
        helper.onCreate(helper.getWritableDatabase());
        TextView result = findViewById(R.id.result);
        Button insert = findViewById(R.id.insert);
        Button search = findViewById(R.id.search);
        Button del1 = findViewById(R.id.delete1);
        Button del2 = findViewById(R.id.delete2);
        Button del3 = findViewById(R.id.delete3);
        Button delall = findViewById(R.id.delall);
        Button update1 = findViewById(R.id.update1);
        Button update2 = findViewById(R.id.update2);
        // 기본 선언입니다.

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.insertData();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                Cursor cursor = helper.search();
                int code = 100;
                while (cursor.moveToNext()) {
                    builder.append(cursor.getString(0)).append(" ")
                            .append(cursor.getString(1)).append(" ")
                            .append(cursor.getString(2)).append("\n");
                }
                cursor.close();
                result.setText(builder.toString());
            }
        });
        del1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deleteData1();
            }
        });
        del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deleteData2();
            }
        });
        del3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deleteData3();
            }
        });
        delall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deleteAll();
            }
        });
        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.update1();
            }
        });
        update2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.update2();
            }
        });
        // 항목 별 클릭 시 리스너입니다.
    }
}