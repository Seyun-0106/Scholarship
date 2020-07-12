package com.cookandroid.scholarship1;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Scholar10 extends AppCompatActivity {
    int SName;

    ListView list_excel;
    ArrayAdapter<String> arrayAdapter;

    TextView tx;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dblist);

        list_excel = (ListView)findViewById(R.id.list_excel2);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        tx = (TextView)findViewById(R.id.result2);
        tx.setMovementMethod(new ScrollingMovementMethod());

        list_excel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Workbook workbook = null;
                Sheet sheet = null;

                String s = "";
                int p = position + 1;

                try {
                    InputStream inputStream = getBaseContext().getResources().getAssets().open("data2-1.xls");

                    workbook = Workbook.getWorkbook(inputStream);
                    sheet = workbook.getSheet(SName);

                    for(int i = 1; i < sheet.getColumns(); i++) {
                        switch(i){
                            case 1:
                                s += "<선발 기준>\n";
                                break;

                            case 2:
                                s +=  "<장학 금액>\n";

                                break;
                            case 3:
                                s += "<신청 서류>\n";
                                break;

                            case 4:
                                s+= "<기타>\n";
                                break;

                            default:
                                break;

                        }
                        // getCell( 세로 , 가로)
                        s += sheet.getCell(i, p).getContents() + "\n\n";
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                } finally {
                    tx.setText(s);
                    workbook.close();
                };
            }
        });


        Intent intent = getIntent(); /*데이터 수신*/

        SName = intent.getExtras().getInt("sheetNum"); /*String형*/

        // 엑셀 열기
        Excel();
    }
    public void Excel() {
        Workbook workbook = null;
        Sheet sheet = null;
        try {
            InputStream inputStream = getBaseContext().getResources().getAssets().open("data2-1.xls");

            workbook = Workbook.getWorkbook(inputStream);
            sheet = workbook.getSheet(SName);   // 이렇게 하면 버튼에 따라 다른 시트가 열림

            for (int i = 1; i < sheet.getRows(); i++) {
                String data = sheet.getCell(0, i).getContents();  //엑셀에서 1열(0)만 골라냄
                arrayAdapter.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {
            list_excel.setAdapter(arrayAdapter);

            workbook.close();
        }
        ;
    }
}
