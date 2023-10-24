package com.example.imagejson;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser {
    private Context context;

    public JSONParser(Context context) {
        this.context = context;
    }

    public ArrayList<Sawon> parsing(String json) {
        ArrayList<Sawon> sawons = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
            // 제이슨 데이터를 가져와 root로 기본 선언합니다.
            JSONArray array = root.getJSONArray((String) root.names().get(0));
            // 제일 큰 데이터집 안에 있는 세부 분할을 배열화합니다.
            // ex) root[array,array,array] 이런식으로 가져옴
            for (int i = 0; i < array.length(); i++) {
                Sawon sawon = new Sawon();
                JSONObject object = array.getJSONObject(i);
                String id = object.getString((String) object.names().get(0));
                String name = object.getString((String) object.names().get(1));
                int salary = object.getInt((String) object.names().get(2));
                String image = object.getString((String) object.names().get(3));
                // 아이디, 이름 등 데이터를 선언합니다.
                sawon.setId(id);
                sawon.setName(name);
                sawon.setSalary(salary);
                sawon.setImage(image);
                sawons.add(sawon);
                // 선언한 데이터들을 파싱해서 정렬합니다.
            }
        } catch (JSONException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }   // 문제가 생길 시 오류 메시지를 출력합니다.

        return sawons;
    }
}
