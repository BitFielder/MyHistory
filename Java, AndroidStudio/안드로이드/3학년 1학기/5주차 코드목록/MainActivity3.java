package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity3 extends AppCompatActivity {
    String page = "https://reqres.in/api/users/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText edit1 = findViewById(R.id.edit1);
        EditText edit2 = findViewById(R.id.edit2);
        Button button2 = findViewById(R.id.button2);
        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        // 입출력 선언입니다.
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit1.getText().toString();
                String address = edit2.getText().toString();
                String site = page + "post";
                String message = "Name="+name+"&Address="+address;
                // 주소 선언입니다.
                if (name.isEmpty()||address.isEmpty()||address.isEmpty()){
                    Toast.makeText(MainActivity3.this, "입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    POSTAsyncTask task = new POSTAsyncTask(MainActivity3.this);
                    try {
                        String json = task.execute(site, message).get();
                        text1.setText(json);
                        // 제이슨 사이트와 연결되는지 확인합니다.
                        JsonParser parser = new JsonParser(MainActivity3.this);
                        text2.setText(parser.parsing2(json));
                        // 확인하면서 받은 json 데이터를 파싱해줍니다.
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}