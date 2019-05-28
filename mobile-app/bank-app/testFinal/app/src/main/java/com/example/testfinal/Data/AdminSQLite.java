package com.example.testfinal.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.accounts.AccountManager.KEY_PASSWORD;

public class AdminSQLite extends SQLiteOpenHelper {
    public AdminSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Base) {
    Base.execSQL("create table usuarios(identificacion int primary key, password int)");
    Base.execSQL("insert into usuarios (identificacion,password) values(123456,123456)");
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

    public boolean validaInformacion(int id, int pass) throws SQLException  {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + "usuarios"
                        + " WHERE " + "identificacion" + " = '" + id + "'", null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            cursor = db.rawQuery(
                    "SELECT * FROM " + "usuarios"
                            + " WHERE " + "password" + " = '" + pass + "'", null);
            if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            return true;
            }
            }
            cursor.close();
            db.close();
        return false;
    }
}
