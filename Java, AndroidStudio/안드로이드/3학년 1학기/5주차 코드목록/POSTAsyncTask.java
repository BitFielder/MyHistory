package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;

import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class POSTAsyncTask extends AsyncTask<String, String, String> {
    StringBuilder builder = new StringBuilder();
    private Context context;
    public POSTAsyncTask(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(4000);
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Context_Type", "application/x-www-form-urlencoded");
            OutputStream outputStream = connection.getOutputStream();
            DataOutputStream request = new DataOutputStream(outputStream);
            request.writeBytes(strings[1]);
            request.flush();
            request.close();
            // 애싱크 테스크 형식의 사이트 연결 과정입니다.
            // 아직 원리를 자세히 이해하지 못해서 테스크 형식의 주석 처리는 조금 어려울 것 같습니다.
            if (connection.getResponseCode() == HttpURLConnection.HTTP_CREATED){
                InputStream inputStream = connection.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                while ((line = reader.readLine())!=null){
                    builder.append(line+"\n");
                }   // 이외는 쓰레드와 동일합니다.
                reader.close();
                streamReader.close();
                inputStream.close();
                connection.disconnect();
            }else {
                publishProgress("통신 오류");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }
}
