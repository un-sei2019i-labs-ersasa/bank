package com.example.testfinal.businessLogic;

import android.content.Context;
import com.example.testfinal.dataAccess.models.Transaction;
import com.example.testfinal.dataAccess.models.User;
import com.example.testfinal.dataAccess.repositories.TransactionRepository;
import com.example.testfinal.dataAccess.repositories.UserRepository;

import java.util.Date;

public class SendMoneyController {
    public UserRepository ur;
    public TransactionRepository tr;
    Context context;
    public SendMoneyController() {
        this.ur = new UserRepository(context);
        this.tr = new TransactionRepository(context);
    }

    public SendMoneyController(Context context) {
        this.context = context;
    }

    public boolean sendMoney(int mailer, int reciever, double ammount){
    User temp_mailer=ur.getUserById(mailer);
    double temp_balance= temp_mailer.getAccount().getBalance();
    if(temp_balance<ammount){
        return false;
    }
    User temp_reciever=ur.getUserById(reciever);
    if(temp_reciever.equals(null)){
        return false;
    }
    if (!updateBalance(temp_mailer,temp_reciever,ammount)){
    return false;
    }
    Date date= new Date();
    //PASAR DATE
    Transaction trans= new Transaction(date,temp_mailer,temp_reciever,ammount);
    tr.createTransaction(trans);
    return true;
    }

    public boolean updateBalance(User mailer, User reciever, double ammount){
    mailer.getAccount().setBalance(mailer.getAccount().getBalance()-ammount);
    ur.updateUser(mailer,mailer.getPassword());
    reciever.getAccount().setBalance(mailer.getAccount().getBalance()+ammount);
    ur.updateUser(reciever,reciever.getPassword());
    return true;
    }
}
