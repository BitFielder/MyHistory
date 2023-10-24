package com.example.sqlitemultitables;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DBHelper helper;
    TextView textView;
    // 다른 함수에서도 사용해야 하기 때문에 여기에 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper(this);

        textView = findViewById(R.id.textview);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("--- customer Table ---\n");
                Cursor cursor = helper.selectCustomer();
                logCursor(cursor,1);
                cursor.close();
            }
        });     // CUSTOMER 테이블에는 C001형식으로 출력을 해야해서 특수한 타입을 설정했습니다.

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("--- product Table ---\n");
                Cursor cursor = helper.selectPRODUCT();
                logCursor(cursor,2);
                cursor.close();
            }
        });     // PRODUCT 테이블에도 P021형식으로 출력을 해야해서 특수한 타입을 설정했습니다.

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("--- sale Table ---\n");
                Cursor cursor = helper.selectJoin();
                logCursor(cursor, 3);
                cursor.close();
            }
        });     // 위와 동일

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("--- sale Table ---\n");
                Cursor cursor = helper.selectName();
                logCursor(cursor,4);
                cursor.close();
            }

        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("--- sale Table ---\n");
                Cursor cursor = helper.selectName2();
                logCursor(cursor,5);
                cursor.close();
            }
        });
    }
    private void logCursor(Cursor cursor, int type) {
        if (cursor.getCount() == 0) {               // 출력 함수입니다.
            textView.append("\n결과가 없습니다.");
        }else if (type == 1){
            while (cursor.moveToNext()) {
                String temp = "";
                String CIDprint = String.format("C%03d",cursor.getInt(0));
                // id 출력형식 변환
                temp = temp.concat(cursor.getColumnName(0) + " : ");
                temp = temp.concat(CIDprint + ", ");
                temp = temp.concat(cursor.getColumnName(1) + " : ");
                temp = temp.concat(cursor.getString(1) + ", ");
                temp = temp.substring(0, temp.length() - 2);
                textView.append(temp +'\n');}
        }else if (type == 2){
            while (cursor.moveToNext()) {
                String temp = "";
                String PIDprint = String.format("P%03d",cursor.getInt(0)+20);
                // id 출력형식 변환
                temp = temp.concat(cursor.getColumnName(0) + " : ");
                temp = temp.concat(PIDprint + ", ");
                for (int i = 1; i <cursor.getColumnCount(); i++) {
                    temp = temp.concat(cursor.getColumnName(i) + " : ");
                    temp = temp.concat(cursor.getString(i) + ", ");}
                temp = temp.substring(0, temp.length() - 2);
                textView.append(temp +'\n');}
        }else if (type == 3){
            while (cursor.moveToNext()) {
                String temp = "";
                String CIDprint = String.format("O%04d",Integer.parseInt(cursor.getString(0))+1234);
                // id 출력형식 변환, 1234 추가
                temp = temp.concat(cursor.getColumnName(0) + " : ");
                temp = temp.concat(CIDprint + ", ");
                for (int i = 1; i <cursor.getColumnCount(); i++) {
                    temp = temp.concat(cursor.getColumnName(i) + " : ");
                    temp = temp.concat(cursor.getString(i) + ", ");}
                temp = temp.substring(0, temp.length() - 2);
                textView.append(temp +'\n');}
        } else {
            while (cursor.moveToNext()) {
                String temp = "";
                for (int i = 0; i <cursor.getColumnCount(); i++) {
                    temp = temp.concat(cursor.getColumnName(i) + " : ");
                    // 컬럼명 출력
                    temp = temp.concat(cursor.getString(i) + ", ");}
                    // 값 출력
                temp = temp.substring(0, temp.length() - 2);
                textView.append(temp +'\n');}
        }
    }
}