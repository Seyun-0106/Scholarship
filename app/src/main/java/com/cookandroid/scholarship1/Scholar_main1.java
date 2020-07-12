package com.cookandroid.scholarship1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Scholar_main1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholar1);

        Button db1 = (Button) findViewById(R.id.db1);
        db1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar1.class);
                i.putExtra("sheetNum", 0);
                startActivity(i);
            }
        });
        Button db2 = (Button) findViewById(R.id.db2);
        db2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar2.class);
                i.putExtra("sheetNum", 1);
                startActivity(i);
            }
        });
        Button db3 = (Button) findViewById(R.id.db3);
        db3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar3.class);
                i.putExtra("sheetNum", 2);
                startActivity(i);
            }
        });
        Button db4 = (Button) findViewById(R.id.db4);
        db4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar4.class);
                i.putExtra("sheetNum", 3);
                startActivity(i);
            }
        });
        Button db5 = (Button) findViewById(R.id.db5);
        db5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar5.class);
                i.putExtra("sheetNum", 4);
                startActivity(i);
            }
        });
    }
}
