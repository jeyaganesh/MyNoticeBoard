package com.example.deepak.mynoticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    public static final String[] titles = new String[]{"Strawberry",
            "Banana", "Orange", "Mixed", "Strawberry",
            "Banana", "Orange", "Mixed"};

    public static final String[] descriptions = new String[]{
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits", "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits"};

    public static final Integer[] images = {R.drawable.india,
            R.drawable.china, R.drawable.indonesia, R.drawable.bangladesh, R.drawable.india,
            R.drawable.china, R.drawable.indonesia, R.drawable.bangladesh};

    ListView listView;
    List<RowItem> rowItems;
    TabLayout tabLayout;
    String[] navigationPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);


        TabLayout tabLayoutMain = (TabLayout) findViewById(R.id.tab_layout_main);

        //RETRIVE DATA FROM THE DATABASE
        String[] navigationPagesMain = new String[]{"EDUCATION", "EXAMS", "OTHERS"};
        for (String str : navigationPagesMain) {
            tabLayoutMain.addTab(tabLayoutMain.newTab().setText(str));
        }
        tabLayoutMain.setTabGravity(TabLayout.MODE_SCROLLABLE);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        //RETRIVE DATA FROM THE DATABASE
        navigationPages = new String[]{"Electrical", "Computer", "GRE", "GATE", "Banking Exams", "MBA", "CAT", "Medical", "Health Care"};
        for (String str : navigationPages) {
            tabLayout.addTab(tabLayout.newTab().setText(str));
        }
        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);

        tabLayoutMain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.removeAllTabs();
                        String[] navigationPages1 = new String[]{"Electrical", "Computer", "Mechanical", "Civil", "Information technology"};

                        for (String str : navigationPages1) {
                            tabLayout.addTab(tabLayout.newTab().setText(str));
                        }
                        break;
                    case 1:
                        tabLayout.removeAllTabs();
                        String[] navigationPages2 = new String[]{"GRE", "GATE", "Banking Exams", "CAT", "CDS", "SSC", "Railway"};
                        for (String str : navigationPages2) {
                            tabLayout.addTab(tabLayout.newTab().setText(str));
                        }
                        break;
                    case 2:
                        tabLayout.removeAllTabs();
                        String[] navigationPages3 = new String[]{"Job alarts", "Software Jobs", "Core Jobs", "Engineering", "Science", "Technology", "Letest News", "Tech Challenges"};
                        for (String str : navigationPages3) {
                            tabLayout.addTab(tabLayout.newTab().setText(str));
                        }
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String option = tab.getText().toString();
                //go to database retrive the cards base on the data populate the fileld
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item, rowItems);
        listView.setAdapter(adapter);


    }

    @Override
    public void onClick(View view) {

        //UPDATE DATABASE BY TAKING THE NEW CHOICES
        Intent i = new Intent(Main3Activity.this, MainActivity.class);

        startActivity(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_preferences) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

