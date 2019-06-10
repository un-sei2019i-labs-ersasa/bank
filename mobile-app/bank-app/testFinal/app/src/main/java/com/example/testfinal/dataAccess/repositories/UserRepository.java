package com.example.testfinal.dataAccess.repositories;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.testfinal.dataAccess.database.Database;
import com.example.testfinal.dataAccess.models.Account;
import com.example.testfinal.dataAccess.models.User;

public class UserRepository {
    private Database db;
    Context context;


    public UserRepository(Context context) {
        this.context = context;
        this.db = new Database(this.context, "Base", null, 1);
    }

    public void createUser(User user) {
        ContentValues values = new ContentValues();
        values.put("id", user.getId());
        values.put("name", user.getName());
        values.put("number_FK", user.getAccount().getNumber());
        values.put("password", user.getPassword());
        values.put("email", user.getEmail());
        db.getWritableDatabase().insert("users", null, values);
        db.close();
    }

    public User getUserById(int id) {
        String select = "SELECT * FROM users WHERE id= "+ id+";";
        Cursor cursor = db.getWritableDatabase().rawQuery(select, null);
        User user = new User();
        if (cursor.moveToFirst()) {
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            int temp_account = cursor.getInt(2);
            String getaccount = "SELECT * FROM accounts WHERE number= "+ temp_account;
            Cursor cursorAccount= db.getReadableDatabase().rawQuery(getaccount,null);
            if(cursorAccount.moveToFirst()) {
                cursorAccount.moveToFirst();
                Account account = new Account();
                account.setNumber(temp_account);
                System.out.println(cursorAccount.getFloat(1));
                account.setBalance(cursorAccount.getFloat(1));
                account.setOwner(cursorAccount.getInt(2));
                user.setAccount(account);
                user.setPassword(cursor.getInt(3));
                user.setEmail(cursor.getString(4));
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
        db.close();
        cursor.close();
        return user;
    }

    public int updateUser(User user, int id) {
        ContentValues values = new ContentValues();
        values.put("id", user.getId());
        values.put("name", user.getName());
        values.put("number_FK", user.getAccount().getNumber());
        values.put("password", user.getPassword());
        values.put("email", user.getEmail());
        return db.getWritableDatabase().update("users", values,
                "id = " + id, null);

    }

    public void deleteUser(int id) {
        db.getWritableDatabase().delete("users", "id=" + id, null);
        db.close();
    }
}
