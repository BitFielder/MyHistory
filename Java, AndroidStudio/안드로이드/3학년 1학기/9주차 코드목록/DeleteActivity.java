package com.example.sqlitereport;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    public SQLiteDatabase db = MainActivity.database;
    final String tblname = "student";    //테이블

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Button deleteTrigger = findViewById(R.id.deletetrigger);
        EditText del1Edit = findViewById(R.id.delEdit1);
        TextView del2 = findViewById(R.id.del2);
        TextView del3 = findViewById(R.id.del3);
        TextView dellog = findViewById(R.id.dellog);

        deleteTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = del1Edit.getText().toString();
                if (del1Edit.equals("")) {      //이름에 입력값이 없다면
                    Toast.makeText(DeleteActivity.this, "이름을 입력하세요.",
                            Toast.LENGTH_SHORT).show();
                } else {                        // 실행
                    String sql = "SELECT * FROM " + tblname +
                            " WHERE name = '" + name + "';";
                    Cursor cursor = db.rawQuery(sql, null);
                    cursor.moveToFirst();
                    // sql으로 이름 검색
                    if (cursor.getCount() == 0) {       // 해당 데이터가 존재하지 않는다면
                        dellog.append("\n 테이블에 해당 데이터가 없습니다.");
                    } else {                            // 존재한다면 삭제
                        del2.setText(cursor.getString(2));
                        del3.setText(cursor.getString(3));
                        // 삭제할 데이터의 나이와 주소 보여주기
                        sql = "DELETE FROM " + tblname +
                                " WHERE name = '" + name + "';";
                        db.execSQL(sql);
                        dellog.append("\n 하나의 레코드를 삭제하였습니다.");
                        // 삭제 후 알림
                        dellog.append("\n 결과창.");
                        sql = "SELECT * FROM " + tblname + ";";
                        cursor = db.rawQuery(sql, null);
                        MainActivity.display(cursor, dellog);
                        int count;
                        try {count = cursor.getCount();}
                        catch (Exception e){count = 0;}
                        dellog.append("\n"+count+"개");
                        MainActivity.updating();
                        // 결과차응ㄹ 보여주고 메인에 새로고침
                    }
                    cursor.close();
                }
            }
        });
        Button fin = findViewById(R.id.delend);
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {finish();}});
        // 메인으로 돌아가기
    }
}