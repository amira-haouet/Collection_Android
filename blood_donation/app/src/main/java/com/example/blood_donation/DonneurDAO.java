package com.example.tddonneur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DonneurDaO {
    String TABLE_NAME="donneur";
    DATAbaseOpenHelper hanlder;
//id INTEGER PRIMARY KEY, name TEXT, groupe TEXT, etat BOOL
    public DonneurDaO(Context context) {
        // this.hanlder = hanlder;
        hanlder = new DATAbaseOpenHelper(context,"", null,1);
    }

    public void ajouter(Donneur p) {
        SQLiteDatabase db = hanlder.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id" , p.getId());
        values.put("name", p.getNom());
        values.put("groupe", p.getGroupe());
        values.put("etat", p.getEtat());
        // Insertion Ligne (Row)
        db.insert(TABLE_NAME, null, values);
        db.close(); // fermer la connection BD
    }
    public void suppression(Integer i) {
        SQLiteDatabase db = hanlder.getWritableDatabase();
        db.delete(TABLE_NAME,"id='"+i+"'",null);
    }
    public Cursor afficher()
    {
        SQLiteDatabase db = hanlder.getReadableDatabase();
        String message="";
        Cursor c=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
//We can test the c.getCount()==0 
      /* while (c.moveToNext()) {
             message=message+ c.getInt(0) + c.getString(1)+c.getInt(2)+"____";
       }*/
        return c;
    }
    public void modifier(Integer i, Donneur p) {
        SQLiteDatabase db = hanlder.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("id" ,p.getId());
        v.put("name", p.getNom());
        v.put("groupe", p.getGroupe());
        v.put("etat", p.getEtat());
        db.update(TABLE_NAME,v, "id='"+i+"'", null);

    }
    public Donneur chercher(Integer i)
    {
        SQLiteDatabase db = hanlder.getReadableDatabase();
        Donneur p = null;
        //Cursor c=db.rawQuery("SELECT * FROM product where id='"+i+"'",null);
        Cursor c = db.rawQuery("SELECT * FROM donneur where id=?", new String[] { i + "" });
//We can test the c.getCount()==0 
        while (c.moveToNext()) {
            //message=message+ c.getInt(0) + c.getString(1)+c.getInt(2)+"____";
            p=new Donneur(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3));
        }

        return p;
    }
}
