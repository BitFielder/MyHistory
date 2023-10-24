package com.example.networksample;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    private Context context;
    private TextView textView;
    private String count;

    public JSONParser(Context context, TextView textView, String count) {
        this.context = context;
        this.textView = textView;
        this.count = count;
    }

    public void parsing(String json) {
        try {
            JSONObject root = new JSONObject(json);
            String date = root.getString((String) root.names().get(2));
            int[] val = new int[6];
            val[0] = root.getInt((String) root.names().get(13));
            val[1] = root.getInt((String) root.names().get(11));
            val[2] = root.getInt((String) root.names().get(12));
            val[3] = root.getInt((String) root.names().get(5));
            val[4] = root.getInt((String) root.names().get(7));
            val[5] = root.getInt((String) root.names().get(4));
            int fv = root.getInt((String) root.names().get(8));

            String result = count+ "회차 ("+date+") 당첨번호 \n";
            for (int i = 0; i < val.length; i++)
                result += "\n당첨번호 "+(i+1)+" : "+ val[i];
            result += "\n보너스 번호 : "+fv;
            textView.setText(result);
        } catch (JSONException e) {
            try {
                JSONObject root = new JSONObject(json);
                String err = root.getString((String) root.names().get(0));
                textView.setText(count+"번째 회차에서 가져온 값은 "+err+"입니다.\n올바른 회차를 입력해주세요.");
            } catch (JSONException ex) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
