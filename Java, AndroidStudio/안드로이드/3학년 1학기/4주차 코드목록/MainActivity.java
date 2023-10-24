package com.example.imagejson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    int type = 1;       //정시철
    String json = "";           //제이슨쓰레드 문서소스 받아올곳
    String task = "";           //애싱크테스크 문서소스 받아올곳

    String page = "http://221.146.23.176:8887/sawon.json";
    //저희집 주소에요 돌려보실 때 꼭 바꿔주세요!

    ArrayList<Sawon> sawons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView1);
        ListView listView = findViewById(R.id.listView);
        //그냥 선언
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type == 1){
                    listView.setVisibility(View.GONE);
                    textView1.setVisibility(View.VISIBLE);
                    // 문서 소스를 보여줘야하니까 리스트뷰를 가립니다.
                    JSONThread thread = new JSONThread(MainActivity.this, page);
                    thread.start();
                    // 쓰레드를 선언하고 작동합니다.
                    try {
                        thread.join();
                        json = thread.getResult();
                        textView1.setText(json);
                        // 쓰레드에서 문서소스를 로딩합니다.
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else if (type == 2) {
                    listView.setVisibility(View.GONE);
                    textView1.setVisibility(View.VISIBLE);
                    // 문서 소스를 보여줘야하니까 리스트뷰를 가립니다.
                    DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                    // 애싱크테스크를 선언합니다.
                    try {
                        task = downloadTask.execute(page).get();
                        textView1.setText(task);
                        // 테스크 작동 동시에 문서소스를 로딩합니다.
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }   // 쓰레드와 달리 캐치 구문이 2개가 존재합니다.
                }

            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type == 1) {
                    JSONThread thread = new JSONThread(MainActivity.this, page);
                    thread.start();
                    try {
                        thread.join();
                        JSONParser parser = new JSONParser(MainActivity.this);
                        sawons = parser.parsing(thread.getResult());
                        // 쓰레드에서 "사원" 목록을 파싱합니다.
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, sawons);
                    listView.setAdapter(adapter);
                    // 어댑터로 파싱한 목록들을 리스트에 넣어줍니다.
                    textView1.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    // 텍스트를 가리고 리스트를 보여줍니다.

                }else if (type == 2){
                    DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                    try {
                        task = downloadTask.execute(page).get();
                        JSONParser parser = new JSONParser(MainActivity.this);
                        sawons = parser.parsing(task);
                        // 테스크에서 "사원" 목록을 파싱합니다.
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, sawons);
                    listView.setAdapter(adapter);
                    // 어댑터로 파싱한 목록들을 리스트에 넣어줍니다.
                    textView1.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    // 텍스트를 가리고 리스트를 보여줍니다.
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                type = 1;
                break;
            case R.id.item2:
                type = 2;
                break;
        }
        item.setChecked(true);
        return true;
    }
}