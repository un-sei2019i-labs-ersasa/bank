package com.example.testfinal.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;

import com.example.testfinal.dataAccess.database.Database;
import com.example.testfinal.dataAccess.models.Transaction;

public class TransactionsRepository {
    private Database db;
    Context context;

    public TransactionsRepository(Context context){
        this.context = context;

    }

    public TransactionsRepository(Database db) {
        this.db = new Database(this.context,"db1",null,1);
    }
    public void createTransaction(Transaction transaction){
        ContentValues values = new ContentValues();
        values.put("id", transaction.getId());
        //falta date,mailer,reciever 
        values.put("monto", transaction.getMonto());
        db.getWritableDatabase().insert("transactions", null, values);
    }
    public Transaction getTransactionById(int id){
    Transaction transaction= new Transaction();
        return transaction;
    }
    public void updateTransaction(Transaction transaction, int id){

    }
    public void deleteTransaction(int id){
        db.getWritableDatabase().delete("transactions", "id=" + id + "\"", null);
        db.close();
    }

}
