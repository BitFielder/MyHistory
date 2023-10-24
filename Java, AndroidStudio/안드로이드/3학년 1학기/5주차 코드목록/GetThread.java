package com.example.myapplication;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetThread extends Thread {

    private Context context;
    private String site;
    private StringBuilder builder = new StringBuilder();
    private Handler handler;
    public GetThread(Context context, String site) {
        this.context = context;
        this.site = site;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(site);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(4000);
            connection.setRequestMethod("GET");
            // 기존의 쓰레드 방식에서 인터넷 로딩에 대한 특수 프로토콜을 추가합니다.
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                while ((line = reader.readLine())!=null){
                    builder.append(line+"\n");
                }
                reader.close();
                streamReader.close();
                inputStream.close();
                connection.disconnect();
            }   // 이 외엔 이전과 유사합니다.
        } catch (IOException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        super.run();
    }
    public String getResult(){
        return builder.toString();
    }
}
