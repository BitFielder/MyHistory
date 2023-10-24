package com.example.imagejson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    int type = 1;
    ArrayList<Sawon> sawons;
    CustomAdapter adapter;
    DatabaseHelper databaseHelper;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        loadDataFromDatabase();

        listView = findViewById(R.id.listView);
        Button pasing = findViewById(R.id.pasing);
        Button desc = findViewById(R.id.desc);
        Button asc = findViewById(R.id.asc);
        Button male = findViewById(R.id.male);
        Button female = findViewById(R.id.female);

        pasing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sawons == null || sawons.isEmpty()) {
                    String jsonData = loadJSONFromRaw(getResources(), R.raw.sawon);
                    JSONParser parser = new JSONParser(MainActivity.this);
                    sawons = parser.parsing(jsonData);
                    insertDataIntoDatabase();
                }

                adapter = new CustomAdapter(MainActivity.this, sawons);
                listView.setAdapter(adapter);
            }
        });

        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortDataDescending();
            }
        });

        asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortDataAscending();
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Sawon> filteredList = new ArrayList<>();
                for (Sawon sawon : sawons) {
                    if (sawon.getGender() != null && sawon.getGender().equals("남")) {
                        filteredList.add(sawon);
                    }
                }
                adapter = new CustomAdapter(MainActivity.this, filteredList);
                listView.setAdapter(adapter);
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Sawon> filteredList = new ArrayList<>();
                for (Sawon sawon : sawons) {
                    if (sawon.getGender() != null && sawon.getGender().equals("여")) {
                        filteredList.add(sawon);
                    }
                }
                adapter = new CustomAdapter(MainActivity.this, filteredList);
                listView.setAdapter(adapter);
            }
        });



    }

    @SuppressLint("Range")
    private void loadDataFromDatabase() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        sawons = new ArrayList<>();

        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Sawon sawon = new Sawon();
            sawon.setId(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
            sawon.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
            sawon.setGender(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_GENDER)));
            sawon.setSalary(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_SALARY)));
            sawon.setImage(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_IMAGE)));
            sawons.add(sawon);
        }

        cursor.close();
        db.close();
    }

    private void insertDataIntoDatabase() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        for (Sawon sawon : sawons) {
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_ID, sawon.getId());
            values.put(DatabaseHelper.COLUMN_NAME, sawon.getName());
            values.put(DatabaseHelper.COLUMN_GENDER, sawon.getGender());
            values.put(DatabaseHelper.COLUMN_SALARY, sawon.getSalary());
            values.put(DatabaseHelper.COLUMN_IMAGE, sawon.getImage());
            db.insert(DatabaseHelper.TABLE_NAME, null, values);
        }

        db.close();
    }

    private void sortDataDescending() {
        type = 2;
        Collections.sort(sawons, new Comparator<Sawon>() {
            @Override
            public int compare(Sawon sawon1, Sawon sawon2) {
                return Integer.compare(sawon2.getSalary(), sawon1.getSalary());
            }
        });
        adapter.notifyDataSetChanged();
    }

    private void sortDataAscending() {
        type = 1;
        Collections.sort(sawons, new Comparator<Sawon>() {
            @Override
            public int compare(Sawon sawon1, Sawon sawon2) {
                return Integer.compare(sawon1.getSalary(), sawon2.getSalary());
            }
        });
        adapter.notifyDataSetChanged();
    }

    private String loadJSONFromRaw(Resources resources, int resId) {
        InputStream inputStream = resources.openRawResource(resId);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            int ctr;
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream.toString();
    }

}
