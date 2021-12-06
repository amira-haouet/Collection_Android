package com.example.productmanagerwithui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductController {




        public static final String CREATE_TABLE = "create table product ( id INTEGER PRIMARY KEY, name TEXT, quantity INTEGER);";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS product ";

        public DataBaseHandler dbHandler;

        //Constructor
        public ProductController(Context context) {
            dbHandler = new DataBaseHandler(context, "", null, 1);
        }

        public void insertdata(Product p) {
            SQLiteDatabase db = dbHandler.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id", p.getId());
            values.put("name", p.getName());
            values.put("quantity", p.getQuantity());
            // Insertion Ligne (Row)
            db.insert("product", null, values);
            db.close(); // fermer la connection BD}

        }


        public void deletedata(Integer first) {
            SQLiteDatabase db = dbHandler.getWritableDatabase();
            db.delete("product", "id='" + first + "'", null);
        }


        public Cursor showdata() {

            SQLiteDatabase db = dbHandler.getReadableDatabase();
            String req = "SELECT * FROM product";
            Cursor c = db.rawQuery(req, null);
            return c;
        }
    public List<Product> getAll() {
        List<Product> result = new ArrayList<>();
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        String req = "SELECT * FROM products";

        Cursor cursor = db.rawQuery(req, null);
        if (cursor.getCount() == 0) return result;

        while (cursor.moveToNext()) {
            result.add(
                    new Product(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getInt(2)
                    )
            );
        }
        cursor.close();
        db.close();
        return result;
    }
    }


