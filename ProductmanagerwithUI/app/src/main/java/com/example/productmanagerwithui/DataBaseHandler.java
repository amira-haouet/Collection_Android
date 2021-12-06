package com.example.productmanagerwithui;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db";

    // DB Version public static final String DATABASE_NAME = "product.db";
    // DB name
    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ProductController.CREATE_TABLE);
    }


    @Override

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(ProductController.DROP_TABLE);

        onCreate(sqLiteDatabase);
    }

}
