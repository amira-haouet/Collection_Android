package com.example.productmanagerwithui;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText idet, nameet, quantiteet;
    Button add, show, delete;
    ProductController dao;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        idet = findViewById(R.id.id);
        nameet = findViewById(R.id.name);
        quantiteet = findViewById(R.id.quantite);

        add = findViewById(R.id.add);
        show = findViewById(R.id.show);
        delete = findViewById(R.id.delete);
        dao = new ProductController(getApplicationContext());


    }

    public void addProd(View view) {


      /*  Product p = new Product(
                Integer.parseInt(String.valueOf(id.getText())), String.valueOf(name.getText()),

                Integer.parseInt(String.valueOf(quantite.getText())));
        System.out.println(p);


*/
        Integer id = Integer.valueOf(idet.getText().toString());
        String name = nameet.getText().toString();
        Integer quantity = Integer.valueOf(quantiteet.getText().toString());

        Product product = new Product(id, name, quantity);

        Log.d("MainActivity", "Adding: " + product.toString());
        dao.insertdata(product);
        this.show(view);
    }

    public void deletProd(View view) {
        dao.deletedata(Integer.parseInt(String.valueOf(idet.getText())));

    }

    String x = "";
    public void deletprod(View view) {
        try {
            Log.d("MainActivity", "Deleting");
            Integer id = Integer.valueOf(idet.getText().toString());
            dao.deletedata(id);
            this.show(view);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("Could not delete product!");
        }
    }
  /*  public void lister() {
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
    }*/


    public void show(View view) {
        try {
            Log.d("MainActivity", "Showing");
            List<Product> myList = dao.getAll();
            Log.d("MainActivity", myList.toString());
            text.setText(myList.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("Could not show products!");
        }
    }
}


