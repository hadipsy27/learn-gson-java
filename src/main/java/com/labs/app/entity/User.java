package com.labs.app.entity;

public class User {

    public String name, email;
    public int umur;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public User() {
    }

    public User(String name, String email, int umur) {
        this.name = name;
        this.email = email;
        this.umur = umur;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", umur=" + umur +
                '}';
    }
}
