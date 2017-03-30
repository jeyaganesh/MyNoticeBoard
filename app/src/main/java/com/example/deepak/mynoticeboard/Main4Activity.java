package com.example.deepak.mynoticeboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ImageView iv=(ImageView)(findViewById(R.id.flag));
        iv.setImageResource(R.drawable.ee);
    }
}
