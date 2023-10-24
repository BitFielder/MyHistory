package com.example.imagejson;

import android.content.Context;
import android.os.Debug;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONThread extends Thread{
    Context context;
    String page;
    String result = "";

    public JSONThread(Context context, String page) {
        this.context = context;
        this.page = page;
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        // 연결하고 데이터를 가져올 시스템 선언
        try {
            URL url = new URL(page);
            connection = (HttpURLConnection) url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;    // 문장을 가져올 스트링 변수를 선언합니다.
            while ((line = reader.readLine()) != null){
                result += (line + "\n");    // 문장을 가져옵니다.
            }
            reader.close();     // 버퍼 리더 닫기
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();    // 연결 종료
        }
    }

    public String getResult() {
        return result;      //가져온 데이터 반환
    }
}
