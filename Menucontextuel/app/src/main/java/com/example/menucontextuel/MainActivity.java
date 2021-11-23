package com.example.menucontextuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.first);
        registerForContextMenu(l);
        text = findViewById(R.id.texte);
        registerForContextMenu(text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {
            case R.id.first: {
                getMenuInflater().inflate(R.menu.menu, menu);


                break;
            }
            case R.id.texte: {
                getMenuInflater().inflate(R.menu.menu2, menu);



            }
//Instructions
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:l.setBackgroundColor(getResources().getColor(R.color.red));break;
            case R.id.yellow:l.setBackgroundColor(getResources().getColor(R.color.yellow));break;
            case R.id.taille:text.setTextSize(12);break;
            case R.id.taille1:text.setTextSize(22);break;
        }
        return super.onContextItemSelected(item);
    }

}