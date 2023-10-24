package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<Reqres> req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button1 = findViewById(R.id.button1);
        ListView listView = findViewById(R.id.listView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String page = "https://reqres.in/api/users?page=2";
                String json = "";
                // 주소와 주소를 받을 제이슨을 미리 선언해줍니다.
                GetThread thread = new GetThread(MainActivity2.this, page);
                thread.start();
                try {
                    thread.join();
                    json = thread.getResult();
                    JsonParser parser = new JsonParser(MainActivity2.this);
                    req = parser.parsing(json);
                    // 쓰레드에서 레큐리스의 유저 목록을 파싱합니다.

                    CustomAdapter adapter = new CustomAdapter(MainActivity2.this, req);
                    listView.setAdapter(adapter);
                    // 어댑터로 파싱한 목록들을 리스트에 넣어줍니다.

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}