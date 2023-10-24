package com.example.sqlitereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static SQLiteDatabase database = null;   //데이터베이스 명령 변수 초기화
    final String dbname = "studentDB";      //데이터베이스 이름
    static final String tblname = "student";    //테이블 이름
    public static TextView mainText;        //main에서 로그 보여주기
    //일부 명령어는 다른 Activity에서 사용해야 하기 때문에 public static 처리했습니다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String sql = "DROP TABLE IF EXISTS " + tblname + ";";
        //deleteDatabase(dbname);       SQL 데이터베이스나 테이블 구문 잘못 썼을 때 초기화용입니다.
        database = openOrCreateDatabase(dbname, MODE_PRIVATE, null);
        String sql = "CREATE TABLE IF NOT EXISTS " + tblname +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT, age TEXT, address TEXT);";
        database.execSQL(sql);
        //데이터베이스, 테이블 기본 생성

        Button addact = findViewById(R.id.addact);
        Button editact= findViewById(R.id.editact);
        Button delact = findViewById(R.id.delact);
        Button qurryact = findViewById(R.id.qurryact);
        mainText = findViewById(R.id.maintext);
        // 선언
        updating();
        // 이전에 사용했던 데이터 불러오기

        addact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);}});
        //Activity 불러오기
        editact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                startActivity(intent);}});
        //Activity 불러오기
        delact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(intent);}});
        //Activity 불러오기

        qurryact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updating();
                Toast.makeText(MainActivity.this, "새로고침", Toast.LENGTH_SHORT).show();
            }
        });
        //쿼리는 새로고침만
    }
    public static void display(Cursor cursor, TextView textView) {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String address = cursor.getString(3);
            textView.append("\n id " + id + " 이름 : " + name +
                    " 나이 : " + age + " 주소 : " + address);
        }
    }       // Curser에서 불러온 데이터 수에 따라 textView에 출력
    public static void updating(){
        mainText.setText("");
        String sql = "SELECT * FROM " + tblname+";";
        Cursor cursor = database.rawQuery(sql, null);
        display(cursor,mainText);
        int count;
        try {count = cursor.getCount();}
        catch (Exception e){count = 0;}
        mainText.append("\n"+count+"개");
    }       //새로고침 함수
}