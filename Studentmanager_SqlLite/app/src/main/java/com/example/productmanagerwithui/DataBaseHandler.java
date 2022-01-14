package com.example.productmanagerwithui;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION= 1;
    public static final String DATABASE_NAME = "etudiant.db";


    public DataBaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentDAO.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(StudentDAO.DROP_TABLE);
        onCreate(db);
    }
}
