package com.example.productmanagerwithui;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {




        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "products";

        public DataBaseHandler(Context context, SQLiteDatabase.CursorFactory factory) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)  {
            db.execSQL(ProductDAO.CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(ProductDAO.DROP_TABLE);
            this.onCreate(db);
        }
    }