package com.example.testfinal.dataAccess.models;


import java.util.Date;

public class Transaction {
    private int id;
    private Date date;
    private User mailer;
    private User reciever;
    private double ammount;

    public Transaction(Date date, User mailer, User reciever, double ammount) {
        this.id=0;
        this.date = date;
        this.mailer = mailer;
        this.reciever = reciever;
        this.ammount = ammount;
}

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getMailer() {
        return mailer;
    }

    public void setMailer(User mailer) {
        this.mailer = mailer;
    }

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }
}