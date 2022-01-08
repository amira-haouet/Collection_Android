package com.example.tddonneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

public class ModificationActivity extends AppCompatActivity {
    DonneurDaO dao;
    EditText nom, id, groupe;
    RadioButton r1, r2;
    Button btn, btnchercher;
    LinearLayout l;

    Donneur donneur_a_chercher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        dao=new DonneurDaO(getApplicationContext());
        groupe=findViewById(R.id.groupe);
        btn=findViewById(R.id.btn);
        id=findViewById(R.id.id);
        nom=findViewById(R.id.nom);
        r2=findViewById(R.id.r2);
        r1=findViewById(R.id.r1);
        l=findViewById(R.id.linear);

        l.setVisibility(View.INVISIBLE);
        btnchercher=findViewById(R.id.btnrecherche);
        btnchercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.setVisibility(View.VISIBLE);
                donneur_a_chercher = dao.chercher(Integer.valueOf(id.getText().toString()));
                nom.setText(donneur_a_chercher.getNom());
                groupe.setText(donneur_a_chercher.getGroupe());
                if(donneur_a_chercher.getEtat()==1)
                {
                    r1.setChecked(true);
                }
                else
                { r2.setChecked(true);}

            }
        });
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Integer etat=1;
               if(r2.isChecked())
               {etat=0;}
               String n=nom.getText().toString();
               String g=groupe.getText().toString();
               Integer i=Integer.valueOf(id.getText().toString());
               Donneur x=new Donneur(i,n,g,etat);
               dao.modifier(i,x);
               startActivity(new Intent(getApplicationContext(), MainActivity.class));
           }
       });
    }
}