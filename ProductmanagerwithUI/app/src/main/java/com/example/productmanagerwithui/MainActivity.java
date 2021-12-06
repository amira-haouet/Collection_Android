package com.example.productmanagerwithui;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText id, name, quantite;
    Button add, show, delete;
    ProductController dao;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        quantite = findViewById(R.id.quantite);

        add = findViewById(R.id.add);
        show = findViewById(R.id.show);
        delete = findViewById(R.id.delete);


    }

    public void addProd(View view) {


        Product p = new Product(
                Integer.parseInt(String.valueOf(id.getText())), String.valueOf(name.getText()),

                Integer.parseInt(String.valueOf(quantite.getText())));
        System.out.println(p);

    }

    public void deletProd(View view) {
        dao.deletedata(Integer.parseInt(String.valueOf(id.getText())));

    }

    String x = "";

    public void lister() {
        Cursor c = dao.showdata();
        if (c.getCount() == 0) {   //empty
        }
        while
        (c.moveToNext()) {

            text.setText(
                    String.valueOf(c.getInt(0) + "" +
                            c.getString(1) + "" +
                            c.getInt(2)) + ""
            );

        }
    }
}


