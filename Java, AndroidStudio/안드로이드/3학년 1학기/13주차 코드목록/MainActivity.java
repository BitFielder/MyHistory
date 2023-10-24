package com.example.gps;

import static android.content.pm.PackageManager.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean isEnable = true;  // GPS 활성화 여부를 저장하는 변수
    LocationManager manager;  // 위치 관리자 객체
    LocationListener locationListener;  // 위치 리스너 객체
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissions();  // 위치 권한 확인
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  // 위치 관리자 객체 생성
        checkgps();  // GPS 활성화 여부 확인

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
    }

    // GPS 활성화 여부
    private void checkgps() {isEnable = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);}

    // 위치 권한 여부
    private void checkPermissions() {
        String[] permission = {
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        };

        int check = PERMISSION_GRANTED;
        for (int i = 0; i < permission.length; i++) {
            check = ContextCompat.checkSelfPermission(this, permission[i]);
            if (check == PERMISSION_DENIED) {
                break;
            }
        }
        if (check == PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_SHORT).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission[0])) {
                Toast.makeText(this, "권한 설정 필요함", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this, permission, 1);
            }
        }
    }

    // 위치 업데이트
    private void startLocationUpdates() {
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                textView1.setText("위도 : " + location.getLatitude());
                textView2.setText("경도 : " + location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(@NonNull String provider) {}

            @Override
            public void onProviderDisabled(@NonNull String provider) {}
            // 아무것도 없는 것 같지만 위도 경도 검색에 필요한 함수들입니다.
        };

        // 위치 권한이 허용되어 있는지 확인하고, 위치 업데이트 요청
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1, locationListener);
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100, 1, locationListener);
            Toast.makeText(this, "위치 업데이트를 시작합니다.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "위치 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu1:
                startLocationUpdates();  // 위치 업데이트 시작 메뉴 선택 시 호출
                item.setChecked(true);
                break;
            case R.id.menu2:
                textView1.setText("위도 : 아직 수신되지 않았음");  // 초기화 메뉴 선택 시 위도 초기화
                textView2.setText("경도 : 아직 수신되지 않았음");  // 초기화 메뉴 선택 시 경도 초기화
                item.setChecked(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

