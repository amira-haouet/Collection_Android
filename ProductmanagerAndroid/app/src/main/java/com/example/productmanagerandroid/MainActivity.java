package com.example.productmanagerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText id, name, qt;
    TextView texte;
    ProductDAO DAO;
    DataBaseHandler DatabaseHandler;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DAO = new ProductDAO(this);


        Product p = new Product(3, "p2", 12);
        Product p1 = new Product(1, "p2", 12);

        DAO.insertdata(p);
        System.out.print(p);

        Cursor c = DAO.showdata();
        if (c.getCount() == 0) {   //empty
        }
        while
        (c.moveToNext()) {
            //get data
            c.getInt(0);
            System.out.println(c.getInt(0));
            System.out.println(c.getString(1));



        }

    }
}