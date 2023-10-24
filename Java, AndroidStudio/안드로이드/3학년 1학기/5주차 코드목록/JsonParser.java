package com.example.myapplication;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser{
    private Context context;

    public JsonParser(Context context) {
        this.context = context;
    }

    public ArrayList<Reqres> parsing(String json) {
        ArrayList<Reqres> req = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
            // 제이슨 데이터를 가져와 root로 기본 선언합니다.
            JSONArray array = root.getJSONArray((String) root.names().get(4));
            // 제일 큰 데이터집 안에 있는 세부 분할을 배열화합니다. ({}는 오브젝트, []는 배열)
            // ex) root[array,array,array] 이런식으로 가져옴
            for (int i = 0; i < array.length(); i++) {
                Reqres rq = new Reqres();
                JSONObject object = array.getJSONObject(i);
                int id = object.getInt((String) object.names().get(0));
                // id는 int형식으로 되어있어서 따로 받아줍니다.
                String email = object.getString((String) object.names().get(1));
                String fname = object.getString((String) object.names().get(2));
                String lname = object.getString((String) object.names().get(3));
                String img = object.getString((String) object.names().get(4));
                rq.setId(id);
                rq.setEmail(email);
                rq.setFname(fname);
                rq.setLname(lname);
                rq.setImg(img);
                req.add(rq);
            }   // 레큐리스 클래스에 변수 값들을 모두 추가, 배열을 돌려줍니다.
        } catch (JSONException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return req;
    }
    public String parsing2(String json){
        StringBuilder builder = new StringBuilder();
        try {
            JSONObject root = new JSONObject(json);
            String name = root.getString((String) root.names().get(0));
            String address = root.getString((String) root.names().get(1));
            String temp1 = root.getString((String) root.names().get(2));
            String temp2 = root.getString((String) root.names().get(3));
            builder.append("이름 : "+name+"\n");
            builder.append("나이 : "+address+"\n");
            builder.append("아이디(임의) : "+temp1+"\n");
            builder.append("만든 날짜 : "+temp2+"\n");
            // 나머지 두개는 이름 나이 외에 그냥 남는거 2개 있길래 넣어봤습니다.
        } catch (JSONException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return builder.toString();
    }
}
