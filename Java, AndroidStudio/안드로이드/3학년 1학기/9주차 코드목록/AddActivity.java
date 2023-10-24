package com.example.sqlitereport;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    public SQLiteDatabase db = MainActivity.database;   //데이터베이스 함수는 Main에서 받아옵니다.
    final String tblname = "student";    //테이블

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        TextView addlog = findViewById(R.id.addlog);            //AddActivity의 기록
        EditText addEdit1 = findViewById(R.id.addEdit1);        //이름
        EditText addEdit2 = findViewById(R.id.addEdit2);        //나이
        EditText addEdit3 = findViewById(R.id.addEdit3);        //주소
        Button add = findViewById(R.id.addtrigger);             //데이터 추가
        // xml의 기본 변수들 선언 모음

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = addEdit1.getText().toString();
                String age = addEdit2.getText().toString();
                String address = addEdit3.getText().toString();
                if (name.equals("") || age.equals("") || address.equals("")) {
                    Toast.makeText(AddActivity.this, "데이터를 모두 입력해주세요.",
                            Toast.LENGTH_SHORT).show();
                    // 하나의 값이라도 입력값이 없을 시
                } else {
                    String sql = "INSERT INTO " + tblname +
                            " (name, age, address) VALUES " + "('" + name + "'," + age + ", '" + address + "');";
                    // 데이터 추가 sql문
                    try {
                        db.execSQL(sql);
                        // sql문 적용
                        addlog.append("\n 데이터 삽입 : "+name+", "+age+"세, "+address);
                    } catch (Exception e) {
                        Toast.makeText(AddActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        addlog.append("\n 데이터 삽입 : 중복데이터 입니다.");
                        // 오류 시 알림
                    }
                }
                MainActivity.updating();
            }
        });

        Button fin = findViewById(R.id.addend);
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {finish();}});
        // 메인으로 돌아가기
    }
}