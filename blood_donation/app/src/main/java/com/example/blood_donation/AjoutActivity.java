package com.example.blood_donation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class AjoutActivity extends AppCompatActivity {
DonneurDaO dao;
EditText nom, id;
RadioButton r1, r2;
Button btn;
Spinner spinner;
    String[] tableau= { "A+", "A-", "o+", "o-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        dao=new DonneurDaO(getApplicationContext());
        spinner=findViewById(R.id.spinner);
        btn=findViewById(R.id.btn);
        id=findViewById(R.id.id);
        nom=findViewById(R.id.nom);
        r2=findViewById(R.id.r2);
        r1=findViewById(R.id.r1);
        ArrayAdapter a=new ArrayAdapter(this,android.R.layout.simple_list_item_1, tableau);
//Create Adapter
        spinner.setAdapter(a);//Bind Adapter to View
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String grp=tableau[spinner.getSelectedItemPosition()];
        Integer etat=1;
        if(r2.isChecked())
        {etat=0;}
        String n=nom.getText().toString();
        Integer i=Integer.valueOf(id.getText().toString());
        Donneur x=new Donneur(i,n,grp,etat);
        dao.ajouter(x);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
});

        /// Donneur x=new Donneur(1,"donneur1","A+",1);
       // dao.ajouter(x);
    }


}