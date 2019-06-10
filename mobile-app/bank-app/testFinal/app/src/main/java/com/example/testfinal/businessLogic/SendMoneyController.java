package com.example.testfinal.businessLogic;

import android.content.Context;
import com.example.testfinal.dataAccess.models.Transaction;
import com.example.testfinal.dataAccess.models.User;
import com.example.testfinal.dataAccess.repositories.AccountRepository;
import com.example.testfinal.dataAccess.repositories.TransactionRepository;
import com.example.testfinal.dataAccess.repositories.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendMoneyController {
    Context context;
    public UserRepository ur;
    public TransactionRepository tr;
    public AccountRepository ar;

    public SendMoneyController(Context context) {
        this.context = context;
        ur=new UserRepository(context);
        tr= new TransactionRepository(context);
        ar= new AccountRepository(context);
    }

    public boolean sendMoney(int mailer, int reciever, float ammount){
    User temp_mailer=ur.getUserById(mailer);
    double temp_balance= temp_mailer.getAccount().getBalance();
    if(temp_balance<ammount){
        return false;
    }
    User temp_reciever=ur.getUserById(reciever);
    if(!temp_reciever.equals(null)) {}
        if (updateBalance(temp_mailer, temp_reciever, ammount)) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            dateFormat.format(date);
            Transaction trans = new Transaction(date, temp_mailer, temp_reciever, ammount);
            tr.createTransaction(trans);
            return true;
        }

    return false;
    }

    public boolean updateBalance(User mailer, User reciever, float ammount){
    mailer.getAccount().setBalance(mailer.getAccount().getBalance()-ammount);
    ar.updateAccount(mailer.getAccount(),mailer.getAccount().getNumber());
    reciever.getAccount().setBalance(reciever.getAccount().getBalance()+ammount);
    ar.updateAccount(reciever.getAccount(),reciever.getAccount().getNumber());
    return true;
    }
}
