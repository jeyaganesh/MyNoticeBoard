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


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener
        {


    ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank;
    String[] country;
    String[] population;
            String[] navigationPages;
    int[] flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //RETRIVE DATA FROM THE DATABASE
        navigationPages=new String[]{"Electrical","Computer","GRE","GATE","Banking Exams","MBA","CAT","Medical","Health Care"};
        for(String str :navigationPages) {
            tabLayout.addTab(tabLayout.newTab().setText(str));
        }
        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);

        //SHOW ONTY FOR 1ST DATA(ie ELECTRICAL)

        // Generate sample data
        rank = new String[] { "The US President Donald Trump on Tuesday signed an order to roll back Barack Obama-era climate change regulations, questioning US' support for an international deal to fight global warming. The regulations required US states to slash carbon emissions from power plants. \"I'm taking historic steps for American energy to reverse government intrusion and cancel job-killing regulations,\" said Trump.", "Mumbai Police will reportedly close the probe into the molestation case against The Viral Fever CEO Arunabh Kumar by this week without filing an FIR. While advocate Rizwan Siddhiqui urged the police thrice to file an FIR in the case, Mumbai Police claimed that they can do so only if any victim comes forward personally and not on social media.", "Samajwadi Party President Akhilesh Yadav on Tuesday said that the Rashtriya Swayamsevak Sangh (RSS) is trying to implement its \"fundamentalist agenda through the BJP governments, which could put the secular character of the country at risk\". \"BJP has no plan for the development of Uttar Pradesh...a new form of corrupt politics has come before us,\" he added.", "TLabs, India's leading startup accelerator has opened applications for its 12th batch, Fall'17 Consumer Batch Program. A maximum of 10 teams will be selected for the program and will receive a funding of ₹30 lakh each for 8% equity. The 16-week long Fall'17 program will focus exclusively on B2C startups.", "Minister of State for Home Hansraj G Ahir on Tuesday said the representation of women police personnel is 7.1% at all India level as of January 1, 2016. All the state governments have been requested to create additional posts for women constables and sub-inspectors by converting the vacant posts of men constables into the posts for women constables, he added.", "The Nashik Police has booked a woman journalist who had allegedly conducted a sting operation over the abuse of the Army's 'Sahayak' system. The journalist had filmed a jawan, Roy Matthew, who had allegedly committed suicide earlier. The journalist from Delhi was booked for abetting suicide, criminal trespassing, and defamation, among others after a complaint was made by Army officials.", "Pellet guns \"maybe\" used by the security forces in Kashmir valley to disperse the rioters if the alternatives fail, the government said on Tuesday. MoS for Home Affairs Hansraj G Ahir added that the possible alternatives to pellet guns include PAVA-chilli (shells and grenades), stun lac (shells and grenades) and tear smoke shells.", "The total valuation of immovable enemy property in the country stands at ₹1.04 lakh crore, the MoS for Home Affairs Hansraj G Ahir informed the Lok Sabha on Tuesday. The statement comes after the Parliament recently amended the Enemy Property Act to guard against claims of succession or transfer of properties left by people who migrated to Pakistan and China.", "The Central Bureau of Investigation (CBI) has filed a supplementary chargesheet against three accused in connection with the Vyapam scam. It was alleged that the accused persons entered into a criminal conspiracy with each other for cheating, forgery, and impersonation in Forest Guard Exam 2013. The accused have been identified as the solver, the middleman, and the candidate.", "A former IIT-Kanpur professor, Sanjeev Dayal, and his wife were rescued on Monday from their apartment, where the duo had locked themselves up for nearly four months. Both of them were found unconscious with excreta littered all over the apartment. The couple had reportedly blocked the toilet door by nailing heavy wooden planks across it." };

        country = new String[] { "China", "India", "United States",
                "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
                "Russia", "Japan" };

        population = new String[] { "1,354,040,000", "1,210,193,422",
                "315,761,000", "237,641,326", "193,946,886", "182,912,000",
                "170,901,000", "152,518,015", "143,369,806", "127,360,000" };

        flag = new int[] { R.drawable.trump, R.drawable.hall,
                R.drawable.man, R.drawable.tlab,
                R.drawable.lady, R.drawable.per, R.drawable.army,
                R.drawable.lea, R.drawable.rid, R.drawable.last };

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(MainActivity.this, rank, country, population, flag);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);


    }
    @Override
    public void onClick(View view) {

        Intent i = new Intent(MainActivity.this,Main2Activity.class);

        startActivity(i);

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
        if (id == R.id.action_settings) {
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

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if (id == R.id.show_event) {
            Intent se = new Intent(MainActivity.this,Main3Activity.class);

            startActivity(se);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
