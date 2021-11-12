package com.example.prepds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    EditText size;
    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//i.putExtra()
     /*   size = findViewById(R.id.size);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                String res = "";
                Integer s = Integer.parseInt(size.getText().toString());
                for (int i = 0; i < s;i++){
                    res+= (char)(new Random().nextInt(26) + 97);
                }

                Intent i = new Intent(MainActivity.this,ResultActivity.class);
                i.putExtra("resultat",res);
                startActivity(i);

            }
        });

        btn2 = findViewById(R.id.clear);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size.setText("");
            }
        });
    }*/
}}