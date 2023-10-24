package com.example.imagejson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, String> {
    Context context;
    // 애싱크 테스크의 데이터 인코딩 방식은 아직 잘 모르겠습니다.
    // 최대한 이해하고 주석을 달아보겠습니다.
    public DownloadTask(Context context) {
        this.context = context;
    }
    @Override
    protected String doInBackground(String... strings) {
        StringBuilder builder = new StringBuilder();
        // 빌더 선언
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 쓰레드와 그대로 연결할 시스템을 선언합니다.
            if (conn != null) {
                conn.setConnectTimeout(10000);
                conn.setUseCaches(false);
                // ??
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream stream = conn.getInputStream();
                    byte[] buffer = new byte[1024];
                    while (stream.read(buffer) != -1)
                        builder.append(new String(buffer));
                    // 어쨋든 버퍼를 통해서 문장을 한줄한줄 받아서 빌더에 집어넣는 것 같습니다.
                    stream.close();
                }
                conn.disconnect();
                // 연결 종료
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
        // 데이터를 반환합니다.
    }
}

