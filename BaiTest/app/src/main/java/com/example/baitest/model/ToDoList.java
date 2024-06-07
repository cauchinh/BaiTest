package com.example.baitest.model;

public class ToDoList {
    private String tenCv;
    private String mota;
    private String thoihan;

    public ToDoList(String tenCv, String mota, String thoihan) {
        this.tenCv = tenCv;
        this.mota = mota;
        this.thoihan = thoihan;
    }

    public ToDoList() {

    }

    public String getTenCv() {
        return tenCv;
    }

    public void setTenCv(String tenCv) {
        this.tenCv = tenCv;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getThoihan() {
        return thoihan;
    }

    public void setThoihan(String thoihan) {
        this.thoihan = thoihan;
    }
}
