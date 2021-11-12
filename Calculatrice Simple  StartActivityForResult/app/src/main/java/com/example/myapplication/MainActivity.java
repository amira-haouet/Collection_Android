package com.example.myapplication;




import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText entier1 ,entier2 ;
    Button button;
    RadioButton radioButton1 ,radioButton2 ;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entier1=findViewById(R.id.a);
        entier2=findViewById(R.id.b);
        button=findViewById(R.id.btn);
        radioButton1=findViewById(R.id.plus);
        radioButton2=findViewById(R.id.moin);
        view=findViewById(R.id.view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext(),IntentActivity.class);
                i.putExtra("num1",entier1.getText().toString());
                i.putExtra("num2",entier2.getText().toString());
                if(radioButton1.isChecked()){
                    i.putExtra("plus","+");
                }else{
                    i.putExtra("moins","-");

                }

                startActivityForResult(i,222);
            }

        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Log.i("XXX","set resultat non=");
        if(requestCode==222){
            if (resultCode==RESULT_OK){
                Integer x =data.getIntExtra("resultat",0);
                Log.i("XXX","set resultat non="+x);

                view.setText("Resultat = "+x.toString());
            }else{
                view.setText("Operation annulée");
            }
        }
    }
}
