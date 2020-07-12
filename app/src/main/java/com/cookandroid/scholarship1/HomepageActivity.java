package com.cookandroid.scholarship1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomepageActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button btn1 = (Button)findViewById(R.id.hp1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www3.chosun.ac.kr/chosun/index.do"));
                startActivity(intent);
            }
        });
        Button btn2 = (Button)findViewById(R.id.hp2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.kosaf.go.kr/"));
                startActivity(intent);
            }
        });
        Button btn3 = (Button)findViewById(R.id.hp3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www3.chosun.ac.kr/sites/scho/index.do"));
                startActivity(intent);
            }
        });
        Button btn4 = (Button)findViewById(R.id.hp4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://portal.chosun.ac.kr/"));
                startActivity(intent);
            }
        });
        Button btn5 = (Button)findViewById(R.id.hp5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www3.chosun.ac.kr/chosun/224/subview.do"));
                startActivity(intent);
            }
        });
        Button btn6 = (Button)findViewById(R.id.hp6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www3.chosun.ac.kr/chosun/220/subview.do"));
                startActivity(intent);
            }
        });
    }
}
