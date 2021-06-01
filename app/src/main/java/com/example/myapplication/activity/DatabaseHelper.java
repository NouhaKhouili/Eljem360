package com.example.myapplication.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Eljem360.db";
    public static final String TABLE_NAME = "usersqlite";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOM";
    public static final String COL_3 = "PRENOM";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PASSWORD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOM TEXT,PRENOM TEXT,EMAIL TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nom,String prenom,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,nom);
        contentValues.put(COL_3,prenom);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String nom,String prenom,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,nom);
        contentValues.put(COL_3,prenom);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,password);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

    public ArrayList<remainder_location_model> getAllReminderLocations() {

        ArrayList<remainder_location_model> locations = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " +TABLE_NAME  ;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {


                remainder_location_model reminderLocationModel = new remainder_location_model();

                reminderLocationModel.setID(cursor.getString(cursor.getColumnIndex(COL_1)));
                reminderLocationModel.setNOM(cursor.getString(cursor.getColumnIndex(COL_2)));
                reminderLocationModel.setPRENOM(cursor.getString(cursor.getColumnIndex(COL_3)));
                reminderLocationModel.setEMAIL(cursor.getString(cursor.getColumnIndex(COL_4)));
                reminderLocationModel.setPASSWORD(cursor.getString(cursor.getColumnIndex(COL_5)));


                locations.add(reminderLocationModel);


            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();
        return locations;
    }
}