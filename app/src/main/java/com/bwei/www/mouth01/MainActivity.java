package com.bwei.www.mouth01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwei.www.mouth01.fragment.ClazzFragment;
import com.bwei.www.mouth01.fragment.HomeFragment;
import com.bwei.www.mouth01.fragment.SortFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ViewPager vpFragment;
    private TextView txtHome;
    private TextView txtClazz;
    private TextView txtCart;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpFragment = findViewById(R.id.vp_fragment);
        txtHome = findViewById(R.id.home);
        txtClazz = findViewById(R.id.clazz);
        txtCart = findViewById(R.id.cart);



        fragmentList = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        ClazzFragment clazzFragment = new ClazzFragment();
        SortFragment sortFragment = new SortFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(clazzFragment);
        fragmentList.add(sortFragment);

        txtHome.setOnClickListener(this);
        txtClazz.setOnClickListener(this);
        txtCart.setOnClickListener(this);
        vpFragment.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
            case R.id.home:
                vpFragment.setCurrentItem(0);
                break;
            case R.id.clazz:
                vpFragment.setCurrentItem(1);
                break;
            case R.id.cart:
                vpFragment.setCurrentItem(2);
                break;
        }
    }
}
