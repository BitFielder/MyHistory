package com.example.sqlitereport;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    public SQLiteDatabase db = MainActivity.database;
    final String tblname = "student";    //테이블
    String beforename, beforeaddress, aftername, afteraddress, beforeage, afterage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        TextView editlog = findViewById(R.id.editlog);
        Button editTrigger1 = findViewById(R.id.edittrigger1);
        Button editTrigger2 = findViewById(R.id.edittrigger2);
        EditText eedit11 = findViewById(R.id.editEdit11);
        EditText eedit12 = findViewById(R.id.editEdit12);
        EditText eedit21 = findViewById(R.id.editEdit21);
        EditText eedit22 = findViewById(R.id.editEdit22);
        EditText eedit31 = findViewById(R.id.editEdit31);
        EditText eedit32 = findViewById(R.id.editEdit32);

        editTrigger1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beforename = eedit11.getText().toString();
                beforeage = eedit21.getText().toString();
                beforeaddress = eedit31.getText().toString();
                // 수정하고싶은 데이터 값 쓰기

                String sql = "SELECT * FROM " + tblname +
                        " WHERE name = '" + beforename + "'and age = '"+beforeage
                        +"'and address = '"+ beforeaddress+"';";
                Cursor cursor = db.rawQuery(sql, null);
                // 세 값이 모두 일치한 값들 호출

                if (cursor.getCount() == 0) {   //값이 존재하지 않는다면
                    editlog.append("\n 테이블에 해당 데이터가 없습니다");
                } else {                        //존재한다면
                    cursor.moveToFirst();
                    eedit11.setEnabled(false);
                    eedit12.setEnabled(true);
                    eedit12.setText(beforename);
                    eedit12.setTextColor(Color.RED);
                    eedit21.setEnabled(false);
                    eedit22.setEnabled(true);
                    eedit22.setText(beforeage);
                    eedit22.setTextColor(Color.RED);
                    eedit31.setEnabled(false);
                    eedit32.setEnabled(true);
                    eedit32.setText(beforeaddress);
                    eedit32.setTextColor(Color.RED);
                    // 수정 전용 EditText를 모두 활성화하여 전체적인 UI를 수정모드로 변경
                }
                cursor.close();
            }
        });
        editTrigger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    aftername = eedit12.getText().toString();
                    afterage = eedit22.getText().toString();
                    afteraddress = eedit32.getText().toString();
                    // 수정된 값 변수에 저장
                    String sql = "UPDATE " + tblname + " SET name = '" + aftername +
                            "', age = " + afterage + ", address = '" +
                            afteraddress + "' WHERE name = '" + beforename + "';";
                    db.execSQL(sql);
                    // 값을 저장한 변수를 sql에 적용

                    editlog.append("\n 하나의 레코드를 수정하였습니다.");
                    sql = "SELECT * FROM " + tblname + ";";
                    Cursor cursor = db.rawQuery(sql, null);
                    // 수정 후 커서 생성
                    MainActivity.display(cursor, editlog);
                    eedit12.setTextColor(Color.BLACK);
                    eedit11.setEnabled(true);
                    eedit12.setEnabled(false);
                    eedit12.setText("");
                    eedit11.setText(aftername);
                    eedit22.setTextColor(Color.BLACK);
                    eedit21.setEnabled(true);
                    eedit22.setEnabled(false);
                    eedit22.setText("");
                    eedit21.setText(afterage);
                    eedit32.setTextColor(Color.BLACK);
                    eedit31.setEnabled(true);
                    eedit22.setEnabled(false);
                    eedit32.setText("");
                    eedit31.setText(afteraddress);
                    cursor.close();
                    MainActivity.updating();
                    // UI 원상복귀, 커서 종료, 메인에 새로고침
                }catch (Exception e){
                    Toast.makeText(EditActivity.this,
                            "데이터를 갱신하는데 오류가 발생하였습니다..", Toast.LENGTH_SHORT).show();
                }   // 오류 발생 시
            }
        });
        Button fin = findViewById(R.id.editend);
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {finish();}});
        // 메인으로 돌아가기
    }
}