package com.example.tddonneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SuppressionActivity extends AppCompatActivity {
EditText id;
Button btn;
DonneurDaO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppression);
        id=findViewById(R.id.id);
        btn=findViewById(R.id.btn);
        dao=new DonneurDaO(getApplicationContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao.suppression(Integer.valueOf(id.getText().toString()));
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}