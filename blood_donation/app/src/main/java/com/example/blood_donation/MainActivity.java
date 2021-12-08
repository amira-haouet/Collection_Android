package com.example.blood_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
EditText et;
Spinner s;
RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DonneurDAO  dDao = new DonneurDAO(this);
      /*  String[]  T = new String[A+,O-]
        ArrayAdapter=new ArrayAdapter<>(Context c, int resource)
*/
    }



}