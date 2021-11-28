package com.example.androidprojectfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnLogOut;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      btnLogOut = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu;
//this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Title

// or id
        switch (item.getItemId()) {
            case R.id.home:home();break;
            case R.id.geocalisation:geo();break;
            case R.id.logout:logout();break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        mAuth = FirebaseAuth.getInstance();

            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }


    private void home() {
        Intent i = new Intent(this,Home.class );
        startActivity(i);

    }

    private void geo() {
        Intent i = new Intent(this,GeoActivity.class );
        startActivity(i);

    }
}