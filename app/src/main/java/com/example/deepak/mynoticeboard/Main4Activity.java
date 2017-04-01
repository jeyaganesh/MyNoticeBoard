package com.example.deepak.mynoticeboard;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main4Activity extends AppCompatActivity {
    ViewPager viewPager;
    int image[];
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ;
        image = new int[] { R.drawable.day1, R.drawable.day2,
                R.drawable.day3, R.drawable.day4,
                R.drawable.day5, R.drawable.day6, R.drawable.day7
                };

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ImageAdapter(Main4Activity.this,image);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
    }
}
