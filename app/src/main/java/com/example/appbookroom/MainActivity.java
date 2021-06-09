package com.example.appbookroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBtNavMainActivity;
    private ViewPager2 mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setupViewPager();
        mBtNavMainActivity.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.action_calendar:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.action_account:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }

    private void init() {
        mBtNavMainActivity = findViewById(R.id.btnav_main_activity);
        mViewPager = findViewById(R.id.view_pager);
    }

    private void setupViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter(this);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mBtNavMainActivity.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        mBtNavMainActivity.getMenu().findItem(R.id.action_calendar).setChecked(true);
                        break;
                    case 2:
                        mBtNavMainActivity.getMenu().findItem(R.id.action_account).setChecked(true);
                        break;
                }
            }
        });
    }
}