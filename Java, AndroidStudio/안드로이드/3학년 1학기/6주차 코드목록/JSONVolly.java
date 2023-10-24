package com.example.networksample;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class JSONVolly {
    private Context context;
    private TextView textView;
    private String count;

    public JSONVolly(Context context, TextView textView, String count) {
        this.context = context;
        this.textView = textView;
        this.count = count;
    }

    public void request(String page) {
        // RequestQueue 생성
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        // StringRequest 생성
        StringRequest request = new StringRequest(Request.Method.GET, page,
                new Response.Listener<String>() {
                    // 성공적으로 응답을 받았을 때 호출되는 콜백 함수
                    @Override
                    public void onResponse(String response) {
                        // JSON 데이터 파싱을 위한 JSONParser 객체 생성
                        JSONParser parser = new JSONParser(context,textView,count);
                        parser.parsing(response);
                    }
                }, new Response.ErrorListener() {
            // 에러가 발생했을 때 호출되는 콜백 함수
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "통신 오류", Toast.LENGTH_SHORT).show();
            }
        });

        // RequestQueue에 요청 객체 추가
        requestQueue.add(request);
    }
}