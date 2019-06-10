package com.example.testfinal.dataAccess.models;

public class Account {
    private int number;
    private float balance;
    private int owner;

    public Account(int number, float balance, int owner) {
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public Account() {
        this.number=0;
        this.balance=0;
        this.owner=0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
