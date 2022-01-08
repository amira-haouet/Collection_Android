package com.example.tddonneur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ListView liste;
TextView res;
DonneurDaO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=findViewById(R.id.listeview);
        res=findViewById(R.id.res);
        dao=new DonneurDaO(getApplicationContext());
        Cursor c=dao.afficher();
        if( c.getCount()==0 ){
            //empty
            res.setText("Aucun Donneur dans la base");
        }
        else{
            String msg="";
            while (c.moveToNext()) {
                String etat_final="Donneur";
                if(c.getInt(3)==0)
                {
                    etat_final="Non Donneur";
                }
                //msg=msg+ c.getInt(0)+"__"+ c.getString(1)+"__"+c.getString(2)+"__"+c.getInt(3)+ '\n';
                msg=msg+ c.getInt(0)+"__"+ c.getString(1)+"__"+c.getString(2)+"__"+etat_final+ '\n';
                res.setText(msg);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.ajout: startActivity(new Intent(getApplicationContext(), AjoutActivity.class));break;
            case R.id.modifier:startActivity(new Intent(getApplicationContext(), ModificationActivity.class));break;
            case R.id.supprimer:startActivity(new Intent(getApplicationContext(), SuppressionActivity.class));break;
        }
        return super.onOptionsItemSelected(item);
    }
}