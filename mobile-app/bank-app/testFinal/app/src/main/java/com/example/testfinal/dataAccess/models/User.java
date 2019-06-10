package com.example.testfinal.dataAccess.models;

public class User {
    private int id;
    private String name;
    private Account account;
    private int password;
    private String email;

    public User(int id, String name, Account account, int password, String email) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.email = email;
    }

    public User() {
        this.id = 0;
        this.name = "";
        this.account = null;
        this.password = 0;
        this.email = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", password=" + password +
                ", email='" + email + '\'' +
                '}';
    }
}
