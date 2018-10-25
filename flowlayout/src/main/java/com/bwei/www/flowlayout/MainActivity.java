package com.bwei.www.flowlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FlowLayoutTwo fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fl = findViewById(R.id.fl);
        for (int i = 0; i < 20; i++) {
            TextView txt = new TextView(this);
//            txt.setText("哈哈哈");
//            txt.setText("恩恩");
//            txt.setText("都要好");
//            txt.setText("是的是的");
//            txt.setText("稀里哗啦");
//            txt.setText("千瓦的是梵蒂冈 ");
//            txt.setText("沃尔特一");
//            txt.setText("人");
            txt.setText("第"+i+"条数据");
            txt.setBackgroundResource(R.drawable.bg);
            ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

            txt.setPadding(30,30,30,30);
            layoutParams.setMargins(100,100,100,100);
            txt.setLayoutParams(layoutParams);
            fl.addView(txt);
        }

    }
}
