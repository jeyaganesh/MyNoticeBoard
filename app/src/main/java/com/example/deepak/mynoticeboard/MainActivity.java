package com.example.deepak.mynoticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener
        {


    ViewPager viewPager;
    PagerAdapter adapter;
    String[] News;
    String[] Author;
    String[] Date;
            String[] navigationPages;
    int[] flag;
            TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       // fab.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TabLayout tabLayoutMain = (TabLayout) findViewById(R.id.tab_layout_main);

        //RETRIVE DATA FROM THE DATABASE
        String[] navigationPagesMain=new String[]{"ACADEMICS","EXAMS","JOBS","SPORTS","MUSIC","OTHERS"};
        for(String str :navigationPagesMain) {
            tabLayoutMain.addTab(tabLayoutMain.newTab().setText(str));
        }
        tabLayoutMain.setTabGravity(TabLayout.MODE_SCROLLABLE);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        //RETRIVE DATA FROM THE DATABASE
       navigationPages=new String[]{"Electrical","Computer","GRE","GATE","Banking Exams","MBA","CAT","Medical","Health Care"};
        for(String str :navigationPages) {
            tabLayout.addTab(tabLayout.newTab().setText(str));
        }
        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);

        tabLayoutMain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //viewPager.setCurrentItem(tab.getPosition());
                switch(tab.getPosition()){
                    case 0:tabLayout.removeAllTabs();
                            String[] navigationPages1=new String[]{"Electrical","Computer","Mechanical","Civil","Information technology"};

                            for(String str :navigationPages1) {
                                    tabLayout.addTab(tabLayout.newTab().setText(str));
                                }
                            break;
                    case 1:tabLayout.removeAllTabs();
                            String[] navigationPages2=new String[]{"GRE","GATE","Banking Exams","CAT","CDS","SSC","Railway"};
                              for(String str :navigationPages2) {
                                tabLayout.addTab(tabLayout.newTab().setText(str));
                                }
                                break;
                    case 2: tabLayout.removeAllTabs();
                            String[] navigationPages3=new String[]{"Job alarts","Software Jobs","Core Jobs","Engineering","Science","Technology","Latest News","Tech Challenges"};
                            for(String str :navigationPages3) {
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
                String option=tab.getText().toString();
                //go to database retrive the cards base on the data populate the fileld
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //SHOW ONTY FOR 1ST DATA(ie ELECTRICAL)

        // Generate sample data
        News = new String[] {"Bigdata!! Bigdata!! Bigdata!! Ever wondered what exactly Big data is?? Big data is a term that describes the large volume of data both structured and unstructured that inundates a business on a day-to-day basis. Organizations collect data from a variety of sources, including business transactions, social media and information from sensor or machine-to-machine data.","Cloud computing is the on-demand delivery of compute power, database storage, applications, and other IT resources through a cloud services platform via the internet with pay-as-you-go pricing.Whether you are running applications that share photos to millions of mobile users or youre supporting the critical operations of your business, a cloud services platform provides rapid access to flexible and low cost IT resources.","With an increase in the breadth of open-source technologies being released by Google, the company is now clubbing all of them under one roof through the release of a dedicated website.Thus, the projects are now being brought together with the release of this directory, which will be the primary hub for all open-source releases.","Sony has reportedly created a portable projector that transforms your wall or table into an interactive touch screen. Touch doesn’t just show images, it responds to you and your touch.Xperia Touch combines infrared light array with 60fps camera capture to turn a flat surface in your home into a 23-inch touchscreen. Xperia Touch automatically turns on when it senses your approach.","Ever wondered how many have qualified in GATE 2017. It is just 16%. Out of 9,22,167 candidates who applied for the exam nearly 7,87,148 attended the exam and just 16% or 1,29,149 have qualified, including general, OBC, SC, ST, or people with disabilities. The qualifying marks are also not high, it is just 25 marks. GATE is conducted by the Indian Institute of Science (IISc) and seven IITs on behalf of the National Coordination Board – GATE, Department of Higher Education, HRD ministry. It tests the comprehensive understanding of engineering and science students of various undergraduate subjects.","The school’s announcement on March 8th that it will begin to accept the Graduate Record Examination (GRE) over the Law School Admission Test (LSAT) from applicants starting this autumn appears to be a bet that Chinese engineers and Indian scientists can help reverse a double-digit decline in applications. ","Mindtree Off Campus Recruitment Drive 2017 | Freshers | Junior Engineer | 2017 Batch | BE/ B.Tech | Across India | April 2017\n" +
                "Mindtree Limited is a global information technology solutions company with revenues of over USD 400 million. Our 11,000 experts engineer meaningful technology solutions to help businesses and societies flourish. Mindtree’s consulting-driven approach makes us a strategic partner to over 40 Fortune 500 enterprises.","Syntel Off Campus Registration Drive 2017 | Syntellect 2017 | Freshers | 2017 Batch | Diploma/ BE/ B.Tech/ B.Sc/ BCS/ BCA/ MCA/ M.Sc/ B.Com/ MA | Across India Syntel Limited is a leading global provider of integrated information technology and Knowledge Process Outsourcing (KPO) solutions spanning the entire lifecycle of business and information systems and processes.","Shell Recruitment 2017 | Freshers | Software Engineer | 2017 Batch | BE/ B.Tech | Bangalore | March 2017 Shell, is an Anglo-Dutch multinational oil and gas company headquartered in the Netherlands and incorporated in the United Kingdom. It is one of the six oil and gas “supermajors” and the fifth-largest company in the world measured by 2015/16 revenues (and the largest based in Europe).","."};

        Author= new String[] { "Deepak", "Sumit", "Anurag",
                "Prasad", "Michael", "Summanth", "Kishor", "Jey",
                "Dev","Ashok"};

        Date= new String[] { "30/03/2017", "30/03/2017",
                "30/03/2017", "30/03/2017", "30/03/2017", "30/03/2017",
                "30/03/2017", "30/03/2017", "30/03/2017" ,"04/01/2017"};

        flag = new int[] { R.drawable.image1, R.drawable.image2,
                R.drawable.image3, R.drawable.image4,
                R.drawable.image5, R.drawable.image9, R.drawable.image8,
                R.drawable.image6, R.drawable.image7,R.drawable.ee};

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(MainActivity.this,News, Author, Date, flag);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);


    }
    @Override
    public void onClick(View view) {



    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent i = new Intent(MainActivity.this,Main2Activity.class);

            startActivity(i);

            return true;
        }
        if (id == R.id.action_education) {
            tabLayout.removeAllTabs();
            String[] navigationPages1=new String[]{"Electrical","Computer","Mechanical","Civil","Information technology"};

            for(String str :navigationPages1) {
                tabLayout.addTab(tabLayout.newTab().setText(str));
            }
            return true;
        }
        if (id == R.id.action_exams) {
            tabLayout.removeAllTabs();
            String[] navigationPages2=new String[]{"GRE","GATE","Banking Exams","CAT","CDS","SSC","Railway"};
            for(String str :navigationPages2) {
                tabLayout.addTab(tabLayout.newTab().setText(str));
            }
            return true;
        }
        if (id == R.id.action_others) {
            tabLayout.removeAllTabs();
            String[] navigationPages3=new String[]{"Job alarts","Software Jobs","Core Jobs","Engineering","Science","Technology","Letest News","Tech Challenges"};
            for(String str :navigationPages3) {
                tabLayout.addTab(tabLayout.newTab().setText(str));
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            Intent ee = new Intent(MainActivity.this,Main4Activity.class);
            startActivity(ee);

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if (id == R.id.show_event) {
            Intent se = new Intent(MainActivity.this,Main3Activity.class);

            startActivity(se);
        }
        else if (id == R.id.preferences) {
            Intent i = new Intent(MainActivity.this,Main2Activity.class);

            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
