package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageThread extends Thread{
    private Context context;
    private String page;
    private Bitmap bitmap;
    private Handler handler = new Handler();

    public ImageThread(Context context, String page) {
        this.context = context;
        this.page = page;
    }

    @Override
    public void run() {

        try {
            URL url = new URL(page);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 이미지를 찾습니다. 제이슨 데이터에 이미지 주소가 있습니다.
            connection.setConnectTimeout(4000);
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            // 비트맵에 이미지를 저장합니다.
        } catch (IOException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            // 이 외는 제이슨 쓰레드와 동일
        }
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
}
