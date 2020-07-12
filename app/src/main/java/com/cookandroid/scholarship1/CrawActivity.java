package com.cookandroid.scholarship1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawActivity extends MainActivity{
    private String  page = "https://www3.chosun.ac.kr/scho/2138/subview.do";
    private String pageUrl = "https://www3.chosun.ac.kr/scho/2138/subview.do"; //파싱 홈페이지 주소
    private String pageUrl2 = "https://www3.chosun.ac.kr/scho/2138/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGc2NobyUyRjMzMiUyRmFydGNsTGlzdC5kbyUzRnBhZ2UlM0Q yJTI2c3JjaENvbHVtbiUzRCUyNnNyY2hXcmQlM0QlMjZiYnNDbFNlcSUzRCUyNmJic09wZW5XcmRTZXElM0QlMjZyZ3NCZ25kZVN0ciUzRCUyNnJnc0VuZGRlU3RyJTNEJTI2aXNWaWV3TWluZSUzRGZhbHNlJTI2";
    private String pageUrl3 = "https://www3.chosun.ac.kr/scho/2138/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGc2NobyUyRjMzMiUyRmFydGNsTGlzdC5kbyUzRnBhZ2UlM0Q zJTI2c3JjaENvbHVtbiUzRCUyNnNyY2hXcmQlM0QlMjZiYnNDbFNlcSUzRCUyNmJic09wZW5XcmRTZXElM0QlMjZyZ3NCZ25kZVN0ciUzRCUyNnJnc0VuZGRlU3RyJTNEJTI2aXNWaWV3TWluZSUzRGZhbHNlJTI2";
    private String pageUrl4 = "https://www3.chosun.ac.kr/scho/2138/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGc2NobyUyRjMzMiUyRmFydGNsTGlzdC5kbyUzRnBhZ2UlM0Q 0JTI2c3JjaENvbHVtbiUzRCUyNnNyY2hXcmQlM0QlMjZiYnNDbFNlcSUzRCUyNmJic09wZW5XcmRTZXElM0QlMjZyZ3NCZ25kZVN0ciUzRCUyNnJnc0VuZGRlU3RyJTNEJTI2aXNWaWV3TWluZSUzRGZhbHNlJTI2";
    private String pageUrl5 = "https://www3.chosun.ac.kr/scho/2138/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGc2NobyUyRjMzMiUyRmFydGNsTGlzdC5kbyUzRnBhZ2UlM0Q 1JTI2c3JjaENvbHVtbiUzRCUyNnNyY2hXcmQlM0QlMjZiYnNDbFNlcSUzRCUyNmJic09wZW5XcmRTZXElM0QlMjZyZ3NCZ25kZVN0ciUzRCUyNnJnc0VuZGRlU3RyJTNEJTI2aXNWaWV3TWluZSUzRGZhbHNlJTI2";
    private String pageUrl6 = "https://www3.chosun.ac.kr/scho/2138/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGc2NobyUyRjMzMiUyRmFydGNsTGlzdC5kbyUzRnBhZ2UlM0Q 2JTI2c3JjaENvbHVtbiUzRCUyNnNyY2hXcmQlM0QlMjZiYnNDbFNlcSUzRCUyNmJic09wZW5XcmRTZXElM0QlMjZyZ3NCZ25kZVN0ciUzRCUyNnJnc0VuZGRlU3RyJTNEJTI2aXNWaWV3TWluZSUzRGZhbHNlJTI2";
    private String pagecompare;

    private String notice = "";
    private String htmlUrl = "";
    String textdata[] = new String[19];
    String urldata[] = new String[19];


    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    int countpage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craw);

        for(int i = 0; i < 19; i++){
            textdata[i] = "";
            urldata[i] = "";
        }

        final Button btn_craw = (Button) findViewById(R.id.btn_craw2);
        btn_craw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();
                countpage = 1;
                
                btn_craw.setVisibility(View.INVISIBLE);    // 버튼 누르면 사라지게
            }
        });

        Button btn_pre = (Button)findViewById(R.id.btn_pre);
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (countpage){
                    case 0: return;
                    case 1:
                        Toast.makeText(getBaseContext(), "이전 페이지가 없습니다.", Toast.LENGTH_SHORT).show();
                        return;

                    case 2:
                        page = pageUrl;
                        countpage--;
                        break;

                    case 3:
                        page = pageUrl2;
                        countpage--;
                        break;

                    case 4:
                        page = pageUrl3;
                        countpage--;
                        break;
                    case 5:
                        page = pageUrl4;
                        countpage--;
                        break;
                    case 6:
                        page = pageUrl5;
                        countpage--;
                        break;

                        default:
                            return;
                }

                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();
            }
        });

        Button btn_next = (Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (countpage){
                    case 0: return;
                    case 1:
                        page = pageUrl2;
                        countpage++;
                        break;

                    case 2:
                        page = pageUrl3;
                        countpage++;
                        break;

                    case 3:
                        page = pageUrl4;
                        countpage++;
                        break;
                    case 4:
                        page = pageUrl5;
                        countpage++;
                        break;

                    case 5:
                        Toast.makeText(getBaseContext(),"다음 페이지가 없습니다", Toast.LENGTH_SHORT).show();
                        return;

                    default:
                        break;
                }
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();
            }
        });
    }
    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progressDialog;//진행바 표시

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(CrawActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); //HORIZONTAL: 0~100까지 막대표시, SPINNER - 원 돌아감
            progressDialog.setMessage("잠시만 기다려 주세요.");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(page).get();

                int i = 0;
                Elements tbodies = document.select("td").select("a[href]");   //a 안에 있는 href 속성을 가진 요소들을 모두 긁어오는 기능
                for (Element body : tbodies) {
                    //htmlUrl += body.attr("abs:href") + "\n";  // 속성 값을 얻어옴
                    htmlUrl = body.attr("abs:href") + "\n";  // 속성 값을 얻어옴
                    urldata[i++] = htmlUrl;
                }

                int j = 0;
                Elements tbodies2 = document.select("td").select(".subject");
                for (Element body : tbodies2) {
                    //notice += body.attr("td.subject") + body.text().trim() + "\n";    // 순수 텍스트 값만 얻어옴
                    notice = body.attr("td.subject") + body.text().trim() + "\n";    // 순수 텍스트 값만 얻어옴
                    textdata[j++] = notice;
                }

//                textdata = notice.split("\n");
//                urldata = htmlUrl.split("\n");



            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            ListView textlistview = (ListView)findViewById(R.id.list_mainview);
            list.clear();
            adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, list);
            adapter.clear();
            adapter.notifyDataSetChanged();

            for(int i = 0; i < textdata.length; i++){
                list.add(textdata[i]);
            }

            textlistview.setAdapter(adapter);

            textlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urldata[position]));
                    startActivity(i);
                }
            });
            
            progressDialog.dismiss();    //진행바 사라짐
        }
    }
}
