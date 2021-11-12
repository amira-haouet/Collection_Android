package com.example.prepds;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Activity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String res="";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        Intent i = new Intent(getApplicationContext(), Main2Activity.class);

i.putExtra("",res);
        startActivity(i);

    }
}