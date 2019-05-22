package com.example.myapplication4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class AnotherActivity extends Activity {
    Spinner currenciesspinner;
    String[] currenciesitems;
    ArrayAdapter<String> adapter;
    Button myexitbutton;
    Button mybutton;
    RadioButton seatcheck;
    RadioButton beathcheck;
    Integer priceseat;
    private static double priceseattotal;
    String member = MainActivity.GetMember();
    private static String seattypetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        currenciesspinner = findViewById(R.id.currenciesspinner);
        currenciesitems = new String[]{"VND","USD"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currenciesitems);
        currenciesspinner.setAdapter(adapter);
        myexitbutton = findViewById(R.id.myexitbutton);
        myexitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        seatcheck = findViewById(R.id.seatcheck);
        seatcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seatcheck.isChecked()){
                    priceseat = 600000;
                    seattypetext = "Seat";
                }
            }
        });
        beathcheck = findViewById(R.id.beathcheck);
        beathcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beathcheck.isChecked()){
                    priceseat = 1200000;
                    seattypetext = "Beath";
                }
            }
        });
        mybutton = findViewById(R.id.mybutton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if (priceseat == null){
                    Toast.makeText(AnotherActivity.this,"Chọn Seat Type!",Toast.LENGTH_LONG).show();
                }
                else{
                    if (currenciesspinner.getSelectedItem().toString() == "VND") {
                        if (member == "Normal") {
                            priceseattotal = priceseat;
                            startActivity(new Intent(AnotherActivity.this, OtherActivity.class));
                        } else {
                            priceseattotal = priceseat * 0.8;
                            startActivity(new Intent(AnotherActivity.this, OtherActivity.class));
                        }
                    } else {
                        if (member == "Normal") {
                            priceseattotal = priceseat / 20000;
                            startActivity(new Intent(AnotherActivity.this, OtherActivity.class));
                        } else {
                            priceseattotal = 0.8 * priceseat / 20000;
                            startActivity(new Intent(AnotherActivity.this, OtherActivity.class));
                        }
                    }
                }
            }
        });
    }
    public static double GetPriceseattotal(){
        return priceseattotal;
    }
    public static String GetSeattypetext(){
        return seattypetext;
    }
}
