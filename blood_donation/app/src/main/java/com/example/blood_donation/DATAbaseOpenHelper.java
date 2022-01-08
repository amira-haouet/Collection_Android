package com.example.tddonneur;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DATAbaseOpenHelper extends SQLiteOpenHelper {
    //public class DataBaseHandler extends SQLiteOpenHelper {
        String CREATE_TABLE=" create table donneur ( id INTEGER PRIMARY KEY, name TEXT, groupe TEXT, etat BOOL); ";
       // String DROP_TABLE ="DROP TABLE IF EXISTS donneur ;";

     /*   public DaDATAbaseOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, "product", factory, 1);
        }*/

    public DATAbaseOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "basedonneur", factory, 1);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //db.execSQL(CREATE_TABLE);
            //db.execSQL(DROP_TABLE);

        }
}
