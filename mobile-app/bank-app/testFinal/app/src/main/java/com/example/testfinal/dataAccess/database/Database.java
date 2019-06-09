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
        //*********************************
        //******CREACION TABLA CUENTAS*****
        //**********************************
        Base.execSQL("create table accounts(number int ," +
                "balance double, owner int, primary key(number))");
        //**********************************
        //******CREACION TABLA USUARIOS*****
        //**********************************
        Base.execSQL("create table users(id int, name varchar " +
                ",account int, password int, email varchar, primary key(id), foreign key (account) references accounts(number))");

        //REVISAR EL INCREMENTO//*********************************************************************************

        //***************************************
        //******CREACION TABLA TRANSACCIONES*****
        //***************************************
        Base.execSQL("create table transactions(id int primary key autoincrement," +
                "date varchar,mailer int, reciever int, ammount double," +
                "foreign key (mailer)references users(id),foreign key (reciever)references users(id))");

        //***********************************
        //*******INGRESAR DATOS EN TABLAS****
        //***********************************
        Base.execSQL("insert into accounts (number,balance,owner) " +
                "values(1234567998,100.567,123456)");

        Base.execSQL("insert into accounts (number,balance,owner) " +
                "values(23456567654,800.887,234567)");

    Base.execSQL("insert into users (id,name,account,password,email) " +
                "values(234567,'RECIEVER_TEST',23456567654,234567,'user1@example.com')");

    Base.execSQL("insert into users (id,name,account,password,email) " +
            "values(123456,'admin',1234567998,123456,'admin@example.com')");

    Base.execSQL("insert into users (id,name,account,password,email) " +
                "values(345678,'MAILER_TEST',0,345678,'user2@example.com')");
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

    public boolean login(int id, int pass) throws SQLException  {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM users WHERE (id= "+ id +") AND ( password= "+ pass+")", null);
        if(cursor.moveToFirst() && cursor.getCount()>0){
            cursor.close();
            db.close();
         return true;
        }
        cursor.close();
            db.close();
        return false;
    }
}
