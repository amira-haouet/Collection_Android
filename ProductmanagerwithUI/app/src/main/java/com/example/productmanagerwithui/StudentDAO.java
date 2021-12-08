package com.example.productmanagerwithui;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentDAO {
    public static final String CREATE_TABLE = "create table etudiant ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Fname TEXT, Sname TEXT, Cls TEXT);" ;

    public static final String DROP_TABLE="DROP TABLE IF EXISTS etudiant ";

    public DataBaseHandler dbHandler;

    //Constructor
    public StudentDAO(Context context) {
        dbHandler = new DataBaseHandler(context,"", null,1);
    }

    public void insertdata(Etudiant p){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Fname",p.getFname());
        values.put("Sname",p.getSname());
        values.put("Cls",p.getCls());
        db.insert("etudiant", null, values);
        db.close();
    }

    public void updateData(Etudiant p){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",p.getId());
        values.put("Fname",p.getFname());
        values.put("Sname",p.getSname());
        values.put("Cls",p.getCls());
        db.update("etudiant",values,"id=?",new String[]{p.getId().toString()});
        db.close();
    }

    public void deletedata(Integer first){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete("etudiant","id="+first+"",null);
        db.close();
    }

    public String findData(Integer first){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery("select Fname , Sname from etudiant where id = ?", new String[] {first.toString()});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        String name= cursor.getString(0);

        String lastName= cursor.getString(1);

        db.close();
        return name+" "+lastName;
    }

    public Cursor showdata(){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String req = "SELECT * FROM etudiant";
        Cursor c = db.rawQuery(req, null);
        return c;
    }

}
