package com.example.jeuCouleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   // RelativeLayout layout;
    EditText taille;
    RadioButton gras, italic;
    TextView texte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taille=findViewById(R.id.edittext);
        gras=findViewById(R.id.gras);
        italic=findViewById(R.id.italic);
        texte=findViewById(R.id.txt);
Intent i=new Intent(getApplicationContext(),Main2Act.class);

        if(gras.isChecked())
        {
          //  View.setTypeface(Typeface.BOLD);

        }
        else
        {

        }
    }
}