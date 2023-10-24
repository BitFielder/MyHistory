package com.example.networksample;

import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

public class JSONFastNetwork {
    // context: 액티비티 또는 컨텍스트 객체, textView: 결과를 출력할 TextView, count: 검색 결과 갯수
    private Context context;
    private TextView textView;
    private String count;

    public JSONFastNetwork(Context context, TextView textView, String count) {
        this.context = context;
        this.textView = textView;
        this.count = count;
    }

    public void request(String page) {
        AndroidNetworking.initialize(context); // AndroidNetworking 초기화

        // GET 요청 보내기
        AndroidNetworking.get(page)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        // JSON 파싱하기
                        JSONParser parser = new JSONParser(context, textView, count);
                        parser.parsing(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        // 통신 에러 처리
                        Toast.makeText(context, "통신 오류", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}