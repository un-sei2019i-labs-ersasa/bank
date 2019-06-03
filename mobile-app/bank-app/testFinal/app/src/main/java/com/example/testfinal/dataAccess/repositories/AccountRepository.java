package com.example.testfinal.dataAccess.repositories;

<<<<<<< HEAD
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.testfinal.dataAccess.database.Database;
import com.example.testfinal.dataAccess.models.Account;


public class AccountRepository {
    private Database db;
    Context context;

    public AccountRepository(Context context){
        this.context = context;
    }

    public AccountRepository(Database db) {
        this.db = new Database(this.context,"db1",null,1);
    }
    public void createAccount(Account account){
        ContentValues values= new ContentValues();
        values.put("number", account.getNumber());
        values.put("owner",account.getOwner());
        values.put("balance", account.getBalance());
    db.getWritableDatabase().insert("accounts",null,values);
    }
    public Account getCountById(int id){
        Account account= new Account(0);
        String select= "SELECT * FROM TABLE usuarios WHERE identification="+id+"\"";
        Cursor cursor=db.getWritableDatabase().rawQuery(select,null);
        if(cursor.moveToFirst()) {
            account.setNumber(cursor.getInt(0));
            account.setOwner(cursor.getString(1));
            account.setBalance(cursor.getInt(2));
        }
        cursor.close();
        return account;
    }
    public void updateAccount(Account account,int number){
        ContentValues values = new ContentValues();
        values.put("number", account.getNumber());
        values.put("owner", account.getOwner());
        values.put("balance", account.getBalance());
        db.getWritableDatabase().update("accounts",values,"number ="+number,null);
    }

    public void deleteAccount(String owner){
        db.getWritableDatabase().delete("accounts","owner= "+owner,null);
        db.close();
    }
=======
public class AccountRepository {
>>>>>>> fca6e8b934503afb251feaac6a5246ebaf9866ef
}
