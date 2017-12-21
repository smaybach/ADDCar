package com.example.lenovo.addcar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.lenovo.addcar.fragment.FragmentGwc;
import com.example.lenovo.addcar.fragment.FragmentSp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> list = new ArrayList<>();
    public ViewPager vp;
    public RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
        //拿到Fragment
        initData();
        //拿到适配器
        MyAdapters adapters = new MyAdapters(getSupportFragmentManager());
        vp.setAdapter(adapters);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.hide();

        //vp 的事件
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rg.check(R.id.sp);
                        break;
                    case 1:
                        rg.check(R.id.gwc);
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //rg点击
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.sp:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.gwc:
                        vp.setCurrentItem(1);
                        break;
                    default:
                        break;
                }
            }
        });
    }
    private void initData() {
        list.add(new FragmentSp());
        list.add(new FragmentGwc());
    }
    //创建一个适配器
    class MyAdapters extends FragmentPagerAdapter {

        public MyAdapters(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}