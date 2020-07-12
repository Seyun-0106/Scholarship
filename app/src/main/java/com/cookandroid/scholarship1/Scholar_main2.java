package com.cookandroid.scholarship1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Scholar_main2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholar2);

        Button db6 = (Button) findViewById(R.id.db6);
        db6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar6.class);
                i.putExtra("sheetNum", 0);
                startActivity(i);
            }
        });
        Button db7 = (Button) findViewById(R.id.db7);
        db7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar7.class);
                i.putExtra("sheetNum", 1);
                startActivity(i);
            }
        });
        Button db8 = (Button) findViewById(R.id.db8);
        db8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar8.class);
                i.putExtra("sheetNum", 2);
                startActivity(i);
            }
        });
        Button db9 = (Button) findViewById(R.id.db9);
        db9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar9.class);
                i.putExtra("sheetNum", 3);
                startActivity(i);
            }
        });
        Button db10 = (Button) findViewById(R.id.db10);
        db10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Scholar10.class);
                i.putExtra("sheetNum", 4);
                startActivity(i);
            }
        });
    }
}
