package com.example.productmanagerwithui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText Sname, name, id;
    TextView texte;
    StudentDAO DAO;
    DataBaseHandler databasehandler;
    RecyclerView recyle ;
    Adapter myAdapter;
    Button add,delete,show,update,search;
    RadioButton ti, dsi, rsi;
    String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DAO = new StudentDAO(this);


        id = findViewById(R.id.id);
        add = findViewById(R.id.btn1);
        delete = findViewById(R.id.btn3);
        show = findViewById(R.id.btn2);
        search= findViewById(R.id.btn4);
        update = findViewById(R.id.btn5);
        Sname = findViewById(R.id.nom);
        name = findViewById(R.id.prenom);
        ti = findViewById(R.id.radio1);
        dsi = findViewById(R.id.radio2);
        rsi = findViewById(R.id.radio3);
        recyle = findViewById(R.id.recyle);










    }







    public void modify_student(View view) {
        if(ti.isChecked()){
            test = "ti";
        }
        if(dsi.isChecked()){
            test = "dsi";
        }

        if(rsi.isChecked()){
            test = "rsi";
        }
        Etudiant p = new Etudiant();
        p.setCls(test);
        p.setSname(Sname.getText().toString());
        p.setFname(name.getText().toString());
        p.setId(Integer.parseInt(id.getText().toString()));
        DAO.updateData(p);

    }

    public void search_student(View view) {
        String result;
        result = DAO.findData(Integer.parseInt(id.getText().toString()));


        List<Etudiant> prodList = new ArrayList<Etudiant>();
        Etudiant prod = new Etudiant(result,"","dsi");
        prodList.add(prod);
        LinearLayoutManager LM = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyle.setLayoutManager(LM);


        myAdapter = new Adapter(prodList);
        recyle.setAdapter(myAdapter);


    }

    public void delete_student(View view) {

        DAO.deletedata(Integer.parseInt(id.getText().toString()));

    }

    public void show_all(View view) {
        List<Etudiant> prodList = new ArrayList<Etudiant>();

        LinearLayoutManager LM = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyle.setLayoutManager(LM);
        //myAdapter = new Adapter(prodList);
        //recyle.setAdapter(myAdapter);
        Cursor c=DAO.showdata();
        if( c.getCount()==0 ){
            //empty
        }
        else{
            while (c.moveToNext()) {
                Etudiant prod1 = new Etudiant();
                String a= c.getString(1);
                prod1.setFname(a);
                String cc =  c.getString(2);
                prod1.setSname(cc);
                String cls = c.getString(3);
                prod1.setCls(cls);
                prodList.add(prod1);
            }}
        myAdapter = new Adapter(prodList);
        recyle.setAdapter(myAdapter);
    }

    public void add_student(View view) {
        if(ti.isChecked()){
            test = "ti";
        }
        if(dsi.isChecked()){
            test = "dsi";
        }

        if(rsi.isChecked()){
            test = "rsi";
        }
        Etudiant p = new Etudiant();
        p.setCls(test);
        p.setSname(Sname.getText().toString());
        p.setFname(name.getText().toString());
        DAO.insertdata(p);
    }
}