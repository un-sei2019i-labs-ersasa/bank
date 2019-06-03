package com.example.testfinal.dataAccess.repositories;
<<<<<<< HEAD
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.testfinal.dataAccess.database.Database;
import com.example.testfinal.dataAccess.models.Account;
import com.example.testfinal.dataAccess.models.User;

public class UserRepository {
    private Database db;
    Context context;

    public UserRepository(Context context){
        this.context = context;

    }

    public UserRepository(Database db) {
        this.db = new Database(this.context,"db1",null,1);
    }

    public void createUser(User user){
        ContentValues values= new ContentValues();
        values.put("id",user.getId());
        values.put("name",user.getName());
        values.put("account",user.getAccount().getNumber());
        values.put("password",user.getPassword());
        values.put("email",user.getEmail());
        db.getWritableDatabase().insert("usuers",null, values);
    }
    public User getUserById(int id){
        String select= "SELECT * FROM TABLE users WHERE identification="+id+"\"";
        Cursor cursor=db.getWritableDatabase().rawQuery(select,null);
        User user= new User();
        if(cursor.moveToFirst()){
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                int temp_account = cursor.getInt(2);
                Account account= new Account(temp_account);
                user.setAccount(account);
                user.setPassword(cursor.getInt(3));
                user.setEmail(cursor.getString(4));
        }
        cursor.close();
        return user;
    }
    public int updateUser(User user,int password){
        ContentValues values = new ContentValues();
        values.put("id",user.getId());
        values.put("name",user.getName());
        values.put("account",user.getAccount().getNumber());
        values.put("password",user.getPassword());
        values.put("email",user.getEmail());
                return db.getWritableDatabase().update("users", values,
                        "password ="+password+"\"",null);

    }
    public void deleteUser(int id){
        db.getWritableDatabase().delete("users","id="+id+"\"",null);
        db.close();
    }
=======

public class UserRepository {
>>>>>>> fca6e8b934503afb251feaac6a5246ebaf9866ef
}
