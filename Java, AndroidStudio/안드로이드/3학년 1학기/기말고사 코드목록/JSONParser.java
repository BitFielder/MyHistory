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
            JSONArray employeeArray = root.getJSONArray("Employee");
            // "Employee" 배열을 가져옵니다.

            for (int i = 0; i < employeeArray.length(); i++) {
                JSONObject employeeObject = employeeArray.getJSONObject(i);
                String id = employeeObject.getString("id");
                String name = employeeObject.getString("name");
                String gender = employeeObject.getString("gender");
                int salary = employeeObject.getInt("salary");
                String image = employeeObject.getString("image");

                Sawon sawon = new Sawon();
                sawon.setId(id);
                sawon.setName(name);
                sawon.setGender(gender);
                sawon.setSalary(salary);
                sawon.setImage(image);

                sawons.add(sawon);
            }
        } catch (JSONException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return sawons;
    }
}
