package com.example.sqlitemultitables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;

    Ball[] balls = {new Ball(1, "축구공", 25000),
            new Ball(2, "배구공", 19000),
            new Ball(3, "야구공", 8000)};
    String[] cname = {"홍길동","김대한","이구슬"};
    int[] CID = {1, 2, 2, 3};
    int[] PID = {1, 1, 3, 2};
    int[] QTY = {2, 1, 5, 3};
    // 배열 선언입니다.

    public DBHelper(@Nullable Context context) {
        super(context, "Report.DB", null, 1);
        this.context = context;
    }   // 생성자, 데이터베이스를 생성하고 최초 생성 시 테이블 onCreate() 함수를 불러옵니다.

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE customer(CID INTEGER PRIMARY KEY, cname TEXT);";
        // Customer 테이블 생성
        try {
            db.beginTransaction();
            db.execSQL(sql);

            ContentValues values = new ContentValues();
            for (int i = 0; i < balls.length; i++) {
                values.put("cid", i + 1);
                values.put("cname",cname[i]);
                db.insert("customer", null, values);
                values.clear();
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Toast.makeText(context, "Rollback", Toast.LENGTH_SHORT).show();
        } finally {
            db.endTransaction();
        }
        // Customer 테이블에 변수를 집어넣습니다.

        sql = "CREATE TABLE product(PID INTEGER PRIMARY KEY, " +
                "PNAME TEXT, COST INTEGER);";
        // Customer 테이블과 동일, 하지만 가져오는 방식이 조금 다릅니다.
        try {
            db.beginTransaction();
            db.execSQL(sql);

            ContentValues values = new ContentValues();
            for (int i = 0; i < cname.length; i++) {
                values.put("PID", balls[i].getPid());
                values.put("PNAME", balls[i].getPName());
                values.put("COST", balls[i].getCOST());
                db.insert("PRODUCT", null, values);
                values.clear();
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Toast.makeText(context, "Rollback", Toast.LENGTH_SHORT).show();
        } finally {
            db.endTransaction();
        }

        sql = "CREATE TABLE sale(ORD_NO INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "CID INTEGER, PID INTEGER, QTY INTEGER);";
        // sale 테이블, 불러오는 형식이 특이하지만 일단 선언은 생각보다 간단합니다.
        try {
            db.beginTransaction();
            db.execSQL(sql);

            ContentValues values = new ContentValues();
            for (int i = 0; i < 4; i++) {
                values.put("CID", CID[i]);
                values.put("PID", PID[i]);
                values.put("QTY", QTY[i]);
                db.insert("SALE", null, values);
                values.clear();
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Toast.makeText(context, "Rollback", Toast.LENGTH_SHORT).show();
        } finally {
            db.endTransaction();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS CUSTOMER;";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS PRODUCT;";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS SALE;";
        db.execSQL(sql);
        onCreate(db);
    }

    public Cursor selectCustomer() {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT CID as id, CNAME as 고객명 FROM CUSTOMER;";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }       // Customer 테이블 선언, 컬럼명을 지정합니다.

    public Cursor selectPRODUCT() {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT PID as id, PNAME as 제품명, COST as 가격 FROM PRODUCT;";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }       // 위와 동일

    public Cursor selectJoin() {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT OD.ORD_NO AS id, " +
                "CU.CNAME AS 고객명, PD.PNAME AS 상품명, OD.QTY AS 수량 " +
                "FROM SALE AS OD " +
                "INNER JOIN CUSTOMER AS CU " +
                "ON OD.CID = CU.CID " +
                "INNER JOIN PRODUCT AS PD " +
                "ON OD.PID = PD.PID;";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }       // Sale 문을 다른 테이블에서 참조합니다. INNER JOIN 구문을 이용합니다.

    public Cursor selectName() {
        SQLiteDatabase db = getWritableDatabase();
        String sql;

        sql = "SELECT " +
                "CU.CNAME AS 고객명, PD.PNAME AS 상품명, OD.QTY AS 수량, (OD.QTY * PD.COST) AS 총금액 " +
                "FROM SALE AS OD " +
                "INNER JOIN CUSTOMER AS CU " +
                "ON OD.CID = CU.CID " +
                "INNER JOIN PRODUCT AS PD " +
                "ON OD.PID = PD.PID " +
                "WHERE CU.CNAME = '" + "홍길동" + "';";

        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }       // 홍길동이 구입한 제품과 가격을 봅니다.

    public Cursor selectName2() {
        SQLiteDatabase db = getWritableDatabase();
        String sql;

        sql = "SELECT CU.CNAME AS 고객명, PD.PNAME AS 상품명, " +
                "OD.QTY AS 수량, (OD.QTY * PD.COST) AS 총금액 " +
                "FROM SALE AS OD " +
                "INNER JOIN CUSTOMER AS CU " +
                "ON OD.CID = CU.CID " +
                "INNER JOIN PRODUCT AS PD " +
                "ON OD.PID = PD.PID " +
                "WHERE CU.CNAME = '" + "김대한" + "';";

        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }       // 김대한이 구입한 제품과 가격을 봅니다.
}
