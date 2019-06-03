package com.example.testfinal.dataAccess.database;

import android.content.ContentValues;
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
    Base.execSQL("create table users(id int primary key,name varchar,account int, password int, email varchar)");
    Base.execSQL("insert into users (id,name,account,password,email) " +
            "values(123456,'admin',0,123456,'admin@example.com')");
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
    public void insertar(int identificacion, int password){
        ContentValues registro= new ContentValues();
        registro.put("identificacion",identificacion);
        registro.put("password", password);
        this.getWritableDatabase().insert("usuarios", null ,registro);

    }

    public boolean login(int id, int pass) throws SQLException  {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM users WHERE id="+id, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            cursor = db.rawQuery(
                    "SELECT * FROM users WHERE password="+pass, null);
            if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
                cursor.close();
            return true;
            }
            }
            cursor.close();
            db.close();
        return false;
    }
}
