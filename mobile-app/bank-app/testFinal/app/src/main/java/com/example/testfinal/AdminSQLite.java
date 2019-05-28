package com.example.testfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLite extends SQLiteOpenHelper {
    public AdminSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Base) {
    Base.execSQL("create table usuarios(identificacion int primary key, password int)");
        ContentValues registro= new ContentValues();
        registro.put("identificacion",123456);
        registro.put("password", 123456);
        this.getWritableDatabase().insert("usuarios", null, registro);
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
    public Cursor validadInformacion(int identificacion, int password) throws SQLException {
        Cursor mcursor= null;
        mcursor=this.getReadableDatabase().query("usuarios", new String[]{"identificacion","password"},"identificacion like " +
                "'"+identificacion+"' and password like '"+password+"'",null,null,null,null);
        return mcursor;
    }
}
