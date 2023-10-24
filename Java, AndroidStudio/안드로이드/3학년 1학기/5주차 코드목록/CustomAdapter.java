package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Reqres> {
    private Context context;
    private ArrayList<Reqres> req;


    public CustomAdapter(@NonNull Context context, ArrayList<Reqres> req) {
        super(context, R.layout.item, req);
        this.context = context;
        this.req = req;
    }

    @Nullable
    @Override
    public Reqres getItem(int position) {
        return req.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Reqres rq = getItem(position);
        ViewHolder holder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 뷰홀더랑 레이아웃을 선언합니다.
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, null);
            // 컨벌트뷰에 item.xml의 레이아웃을 받아옵니다.
            holder.imageView = convertView.findViewById(R.id.image);
            holder.id = convertView.findViewById(R.id.id);
            holder.name = convertView.findViewById(R.id.name);
            holder.email = convertView.findViewById(R.id.email);
            // 변수 홀더에 컨벌트뷰에 받아온 변수를 선언합니다.
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.id.setText(String.valueOf(rq.getId()));
        holder.name.setText(rq.getFname()+" "+rq.getLname());
        // 성, 이름 사이에 띄어쓰기 하나 추가
        holder.email.setText(rq.getEmail());
        // 선언한 홀더 변수에 파싱 목록을 받아줍니다.

        ImageThread thread = new ImageThread(context, rq.getImg());
        thread.start();
        // 이미지 쓰레드를 선언하고 스타트, 쓰레드 원리는 JSON 쓰레드와 유사합니다.
        try {
            thread.join();
            holder.imageView.setImageBitmap(thread.getBitmap());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return convertView;
        // 컨벌트뷰를 돌려줍니다. (추측상 어댑터에서 가공한 프로그램 데이터 집 같습니다.)
    }

    private class ViewHolder {
        ImageView imageView;
        TextView id;
        TextView name;
        TextView email;
    }
}