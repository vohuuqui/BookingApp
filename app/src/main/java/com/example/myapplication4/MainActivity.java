package com.example.myapplication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText nametext;
    private static EditText phonetext;
    Button myexitbutton;
    Button mybutton;
    CheckBox checkVip;
    private static String member = "Normal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nametext = findViewById(R.id.nametext);
        phonetext = findViewById(R.id.phonetext);
        checkVip = findViewById(R.id.checkVip);
        checkVip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkVip.isChecked()){
                    member = "Vip";
                }
                else {
                    member = "Normal";
                }
            }
        });
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
            public void onClick(View v) {
                if (nametext.length() == 0){
                    Toast.makeText(MainActivity.this,"Nhập Tên!",Toast.LENGTH_LONG).show();
                }
                else if (phonetext.length() == 0){
                    Toast.makeText(MainActivity.this,"Nhập Số Điện Thoại!",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(MainActivity.this, AnotherActivity.class));
                }
            }
        });
    }
    public static EditText GetName(){
        return nametext;
    }
    public static EditText GetPhone(){
        return phonetext;
    }
    public static String GetMember(){
        return member;
    }
}
