package com.example.tpmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu;
//this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu;
//this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu;
//this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Title

// or id
        switch (item.getItemId()) {
            case R.id.act2:create();break;
            case R.id.quitter:finish();break;
            case R.id.parametre:parametre();break;
            case R.id.langue:langue();break;
 }
        return super.onOptionsItemSelected(item);
    }

    private void langue() {
        Intent langue=  new Intent(Settings.ACTION_LOCALE_SETTINGS);
        startActivity(langue);

    }

    private void parametre() {

        Intent manager=  new Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
        startActivity(manager);
    }

    private void create() {
        Intent i = new Intent(this,activity2.class );
        startActivity(i);

    }
}