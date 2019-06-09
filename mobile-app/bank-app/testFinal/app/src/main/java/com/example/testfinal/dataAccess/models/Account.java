package com.example.testfinal.dataAccess.models;

public class Account {
    private int number;
    private double balance;
    private int owner;

    public Account(int number, int balance, int owner) {
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public Account(int number) {
        this.number=number;
        this.balance=0;
        this.owner=0;
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
