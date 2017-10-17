package com.zhang.part;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private String url = "http://v.juhe.cn/chengyu/query";
    private Map<String, Object> parmas = new HashMap<>();
    private TextView mTextView;
    private ListView xmListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mListView = (ListView) findViewById(R.id.list);
        mTextView = (TextView) findViewById(R.id.tv);
        parmas.put("word","%E5%8D%A7%E8%96%AA%E5%B0%9D%E8%83%86");
        parmas.put("key","74f1610aed28f2593756446566522715");
        Log.e(TAG, "onCreate: "+ parmas.size());
    }
    
    private void initdata() {
        ArrayList<String> data = new ArrayList<>();
        for(int i=1;i<101;i++){
            if(i<10){
               data.add("我是数据=====0"+i);
            }else{
                data.add("我是数据====="+i);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
//        mListView.setAdapter(adapter);
    }

    public void onClick(View view){
        HttpProxy.obtain().post(url, parmas, new HttpCallBack<SetInfo>() {

            private String mReason;

            @Override
            public void onSuccess(SetInfo setInfo) {
                mReason = setInfo.getReason();
                Log.e(TAG, "onSuccess:=== " + setInfo.getResult().toString());
                StringBuilder sb = new StringBuilder();
                if (setInfo != null) {
                    sb.append("来源:聚合数据")
                            .append("\r\n")
                            .append("成语:卧薪尝胆")
                            .append("\r\n")
                            .append("来自:" + setInfo.getResult().getFrom_())
                            .append("\r\n")
                            .append("意思:" + setInfo.getResult().getCiyujs())
                            .append("\r\n")
                            .append("描述:" + setInfo.getResult().getYinzhengjs());

                }
                mTextView.setText(sb.toString());

            }

            @Override
            public void onFail(String e) {
                Toast.makeText(MainActivity.this, mReason, Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFail: " + e.toString());
            }
        });

    }
}
