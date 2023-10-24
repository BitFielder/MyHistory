package com.example.sqlitemultitables;

public class Ball {

    private int pid;
    private String pname;
    private int COST;

    public Ball(int pid, String pname, int price) {
        this.pid = pid;
        this.pname = pname;
        this.COST = price;
    }
    // 생성자

    public int getPid() {
        return pid;
    }

    public String getPName() {
        return pname;
    }

    public int getCOST() {
        return COST;
    }
    // 불러오기
}
