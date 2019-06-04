package com.example.testfinal.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.testfinal.dataAccess.database.Database;
import com.example.testfinal.dataAccess.models.Transaction;

import java.text.SimpleDateFormat;

public class TransactionRepository {
    private Database db;
    Context context;

    public TransactionRepository(Context context){
        this.context = context;
    }

    public TransactionRepository(Database db) {
        this.db = new Database(this.context,"db1",null,1);
    }
    public void createTransaction(Transaction transaction){
        ContentValues values = new ContentValues();
        values.put("id", transaction.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(transaction.getDate());
        values.put("date",date);
        values.put("mailer",transaction.getMailer().getId());
        values.put("reciever",transaction.getReciever().getId());
        values.put("ammount", transaction.getAmmount());
        db.getWritableDatabase().insert("transactions", null, values);
    }
    public Transaction getTransactionById(int id){
    Transaction transaction= new Transaction();
        String select= "SELECT * FROM TABLE usuarios WHERE identification="+id+"\"";
        Cursor cursor=db.getWritableDatabase().rawQuery(select,null);
        if (cursor.moveToFirst()) {
            transaction.setId(cursor.getInt(0));
            transaction.setDate(null);
            transaction.setMailer(null);
            transaction.setReciever(null);
            transaction.setAmmount(cursor.getDouble(4));
        }
        cursor.close();
        return transaction;
    }
    public int updateTransaction(Transaction transaction, int id){
    ContentValues values= new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(transaction.getDate());
        values.put("date",date);
        values.put("mailer",transaction.getMailer().getId());
        values.put("reciever",transaction.getReciever().getId());
        values.put("ammount", transaction.getAmmount());
        return db.getWritableDatabase().update("transactions",values,"id = "+id,null);
    }
    public void deleteTransaction(int id){
        db.getWritableDatabase().delete("transactions", "id=" + id, null);
        db.close();
    }

}
