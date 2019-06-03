package com.example.testfinal.dataAccess.models;

public class Account {
    private int number;
    private double balance;
    private String owner;

    public Account(int number, int balance, String owner) {
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public Account(int number) {
        this.number=number;
        this.balance=0;
        this.owner=null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
