package com.example.blood_donation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DonneurDAO {
    public static final String CREATE_TABLE = "create table blooddonation ( id INTEGER " +
            "PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT, groupesanguin TEXT, state Boolean);" ;

    public static final String DROP_TABLE="DROP TABLE IF EXISTS blooddonation ";

    public DataBaseHandler dbHandler;

    //Constructor
    public DonneurDAO(Context context) {
        dbHandler = new DataBaseHandler(context,"", null,1);
    }

    public void insertdata(Donneur d){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id",d.getId());
        values.put("name",d.getNom());
        values.put("groupesanguin",d.getGroupesanguin());
        values.put("state",d.getState());
        db.insert("blooddonation", null, values);
        db.close();
    }


    public Cursor showdata(){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String req = "SELECT * FROM blooddonation";
        Cursor c = db.rawQuery(req, null);
        return c;
    }
    public void updateData(Donneur d,Integer i){
        d=findData(i);
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",d.getId());
        values.put("name",d.getNom());
        values.put("groupesanguin",d.getGroupesanguin());
        values.put("state",d.getState());
        db.update("blooddonation",values,"id=?",new String[]{d.getId().toString()});
        db.close();
    }

    public void deletedata(Integer first){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete("etudiant","id="+first+"",null);
        db.close();
    }

    public Donneur findData(Integer first){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from blooddonation where id = ?", new String[] {first.toString()});
      /*  if (cursor != null) {
            cursor.moveToFirst();
        }
        String name= cursor.getString(0);

        String lastName= cursor.getString(1);
*/
        Donneur d= new Donneur(cursor.getInt(0),cursor.getString(1),

                cursor.getString(2),Boolean.parseBoolean(cursor.getString(4)));

        db.close();
        return d;
    }



}



