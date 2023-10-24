package com.example.networksample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    // type 변수는 API 요청 방식을 지정하는데 사용됩니다.
    int type = 1;

    // count 변수는 로또 회차를 입력받습니다.
    String count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소들을 레이아웃에서 찾아서 변수에 저장합니다.
        EditText input = findViewById(R.id.input);
        Button button = findViewById(R.id.button);
        TextView rst = findViewById(R.id.rst);

        // 버튼 클릭 이벤트 리스너를 설정합니다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = input.getText().toString();
                // 입력한 회차가 없으면 토스트 메시지를 출력합니다.
                if (count.equals(""))
                    Toast.makeText(MainActivity.this, "회차를 입력해주세요.", Toast.LENGTH_SHORT).show();
                else {
                    // API 요청 URL을 생성합니다.
                    String page = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="+count;
                    switch (type) {
                        case 1:
                            // JSON 데이터를 가져오는 스레드를 생성하고 실행합니다.
                            JSONThread thread = new JSONThread(MainActivity.this, page);
                            thread.start();
                            try {
                                // 스레드가 종료될 때까지 대기합니다.
                                thread.join();
                                // JSON 데이터를 파싱하는 객체를 생성하고 실행합니다.
                                JSONParser parser = new JSONParser(MainActivity.this, rst, count);
                                parser.parsing(thread.getResult());
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2:
                            // JSON 데이터를 다운로드하는 AsyncTask 객체를 생성하고 실행합니다.
                            DownloadTask downloadTask = new DownloadTask(MainActivity.this);
                            try {
                                // 다운로드한 JSON 데이터를 파싱하는 객체를 생성하고 실행합니다.
                                JSONParser parser = new JSONParser(MainActivity.this, rst, count);
                                parser.parsing(downloadTask.execute(page).get());
                            } catch (ExecutionException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 3:
                            // JSON 데이터를 가져오는 Volley 요청을 생성하고 실행합니다.
                            JSONVolly volly = new JSONVolly(MainActivity.this, rst, count);
                            volly.request(page);
                            break;
                        case 4:
                            // JSON 데이터를 가져오는 OkHttp 요청을 생성하고 실행합니다.
                            JSONFastNetwork fastNetwork = new JSONFastNetwork(MainActivity.this, rst, count);
                            fastNetwork.request(page);
                    }
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
        switch (item.getItemId()) {
            case R.id.item1:
                type = 1;
                break;
            case R.id.item2:
                type = 2;
                break;
            case R.id.item3:
                type = 3;
                break;
            case R.id.item4:
                type = 4;
        }
        item.setChecked(true);
        return true;
    }
}