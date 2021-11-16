package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*  String[] tab= {"Lundi", "Mardi", "Mercredi"};
      ListView maliste;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          maliste=findViewById(R.id.listview);
          ArrayAdapter a= new
                  ArrayAdapter(this,android.R.layout.simple_list_item_1, tab);
          maliste.setAdapter(a);}*/
    private List<Contact> stList = new ArrayList<>(); private
    RecyclerView recyclerView;
    private Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager LM = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(LM);
        Contact s= new Contact("Walt Disney", "123456");
        stList.add(s);
        s = new Contact("Bill Gates", "789456");
        stList.add(s);
        s = new Contact("Amira haouet", "2450");
        stList.add(s);
        myAdapter = new Adapter(stList);
        recyclerView.setAdapter(myAdapter);
    }
}