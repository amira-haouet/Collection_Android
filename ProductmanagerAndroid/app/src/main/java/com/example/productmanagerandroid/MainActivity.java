package com.example.productmanagerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;


import android.view.View;


import com.example.productmanagerandroid.dao.ProductDAO;
import com.example.productmanagerandroid.models.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText idEt, nameEt, quantityEt;
    TextView productsTv;

    ProductDAO productDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEt = findViewById(R.id.id_inp);
        nameEt = findViewById(R.id.name_inp);
        quantityEt = findViewById(R.id.qty_inp);
        productsTv = findViewById(R.id.products_tv);

        productDAO = new ProductDAO(getApplicationContext());
    }

    private void clearInputs() {
        idEt.setText("");
        nameEt.setText("");
        quantityEt.setText("");
    }

    public void onAdd(View view) {

            Integer id = Integer.valueOf(idEt.getText().toString());
            String name = nameEt.getText().toString();
            Integer quantity = Integer.valueOf(quantityEt.getText().toString());

            Product product = new Product(id, name, quantity);

            Log.d("MainActivity", "Adding: " + product.toString());
            productDAO.insert(product);
            this.clearInputs();
            this.onShow(view);

    }

    public void onDelete(View view) {

            Log.d("MainActivity", "Deleting");
            Integer id = Integer.valueOf(idEt.getText().toString());
            productDAO.delete(id);
            this.clearInputs();
            this.onShow(view);

    }

    public void onShow(View view) {

            Log.d("MainActivity", "Showing");
            List<Product> myList = productDAO.getAll();
            Log.d("MainActivity", myList.toString());
            productsTv.setText(myList.toString());

    }

}