package com.example.myapplication4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends Activity {
    TextView mytext;
    Button myexitbutton;
    Button mybutton;
    EditText nametext = MainActivity.GetName();
    EditText phonetext = MainActivity.GetPhone();
    String member = MainActivity.GetMember();
    String seattypetext = AnotherActivity.GetSeattypetext();
    double priceseattotal = AnotherActivity.GetPriceseattotal();
    String mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        mytext = findViewById(R.id.mytext);
        mytext.setText("Name: " + nametext.getText().toString() + "\n" + "Phone: " + phonetext.getText().toString() + "\n" + "Member: " + member + "\n" + "Seat Type: " + seattypetext + "\n" + "Price: " + priceseattotal);
        myexitbutton = findViewById(R.id.myexitbutton);
        myexitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        mybutton = findViewById(R.id.mybutton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                mess = "Name: " + nametext.getText().toString() + "\n" + "Phone: " + phonetext.getText().toString() + "\n" + "Member: " + member + "\n" + "Seat Type: " + seattypetext + "\n" + "Price: " + priceseattotal;
                Display(mess);
            }
        });
    }
    private void Display(String mess){
        AlertDialog.Builder Alert = new AlertDialog.Builder (OtherActivity.this );
        Alert.setMessage(mess);
        Alert.setTitle("Information");
        Alert.setPositiveButton("OK",null);
        Alert.setCancelable(true);
        Alert.create().show();
    }
}
