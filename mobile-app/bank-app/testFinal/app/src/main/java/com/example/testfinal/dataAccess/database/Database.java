package com.example.testfinal.dataAccess.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Base) {
    Base.execSQL("create table users(id int primary key, name varchar, account int, password int, email varchar)");
    Base.execSQL("INSERT INTO users (id,name,account,password,email) values (123456,'admin',0,123456,'admin@email.com')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Base, int oldVersion, int newVersion) {

    }

    public void abrir(){
        this.getWritableDatabase();
    }
    public void cerrar(){
        this.close();
    }

    public boolean login(int id_temp, int pass) throws SQLException  {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM users WHERE id = " + id_temp, null);

        if (cursor.getCount()>0) {
            cursor = db.rawQuery(
                    "SELECT * FROM users WHERE password= " + pass, null);
            if (cursor.getCount()>0) {
                db.close();
                return true;
            }
            else{
                db.close();
                return false;
            }
            }
            cursor.close();
            db.close();
            return false;
    }
}
