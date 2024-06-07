package com.example.baitest.model;

public class Profile {
    private String username;
    private String email;
    private int hinh;


    public Profile(String username, String email, int hinh) {
        this.username = username;
        this.email = email;
        this.hinh = hinh;
    }

    public Profile() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
