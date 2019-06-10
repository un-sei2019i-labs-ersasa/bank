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
        //*********************************
       Base.execSQL("CREATE TABLE accounts(number INTEGER NOT NULL PRIMARY KEY, balance FLOAT NOT NULL, owner INTEGER  NOT NULL)");
       //**********************************
        //******CREACION TABLA USUARIOS*****
        //**********************************

        Base.execSQL("CREATE TABLE users(id INTEGER NOT NULL PRIMARY KEY, name TEXT NOT NULL, number_FK INTEGER NOT NULL" +
                ", password INTEGER NOT NULL, email INTEGER NOT NULL, FOREIGN KEY(number_FK) REFERENCES accounts(number))");
        //***************************************
        //******CREACION TABLA TRANSACCIONES*****
        //***************************************
       Base.execSQL("CREATE TABLE transactions(date VARCHAR(11),mailer INTEGER, reciever INTEGER, ammount FLOAT" +
                ",FOREIGN KEY (mailer) REFERENCES users(id),FOREIGN KEY (reciever) REFERENCES users(id))");
        //***********************************
        //*******INGRESAR DATOS EN TABLAS****
        //***********************************
        Base.execSQL("INSERT INTO accounts VALUES(123456,100,123456)");

        Base.execSQL("INSERT INTO accounts VALUES(234567,456,234567)");

    Base.execSQL("INSERT INTO users VALUES(234567,'RECIEVER_TEST',234567,234567,'user1@example.com')");

    Base.execSQL("INSERT INTO users values(123456,'admin',123456,123456,'admin@example.com')");

    Base.execSQL("INSERT INTO users VALUES(345678,'MAILER_TEST',3456,345678,'user2@example.com')");

    }
    @Override
    public void onUpgrade(SQLiteDatabase Base, int oldVersion, int newVersion) {

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
