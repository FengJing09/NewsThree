package com.bwei.www.animator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView1;
    private TextView textView2;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.vp_s);
        textView1 = findViewById(R.id.fl);
        textView2 = findViewById(R.id.gwc);
        fragmentList = new ArrayList<>();
        FlFragment flFragment = new FlFragment();
        gwcFragment fragment = new gwcFragment();
        fragmentList.add(flFragment);
        fragmentList.add(fragment);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fl:
                viewPager.setCurrentItem(0);
                break;
            case R.id.gwc:
                viewPager.setCurrentItem(1);
                break;
        }

    }
}
