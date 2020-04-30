package com.example.pohs.DashBoard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.pohs.R;
import com.example.pohs.Search.Searchfirst;
import com.google.android.material.tabs.TabLayout;


public class CustomerDashBoard extends AppCompatActivity {

    private Toolbar mtoolbar;
    private ViewPager mViewpager;
    private SectionPageDepterforCU mSectionPageAdepter;
    private TabLayout mtablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dash_board);


        mtoolbar = (Toolbar)findViewById(R.id.cu_dashboard_toolbar);
       //setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("CUSTOMER DASHBOARD");

        mViewpager = (ViewPager)findViewById(R.id.sh_dashboard_tabpager);

      mSectionPageAdepter = new SectionPageDepterforCU(getSupportFragmentManager());
      mViewpager.setAdapter(mSectionPageAdepter);

      mtablayout = (TabLayout)findViewById(R.id.cu_dashboard_tabs);
      mtablayout.setupWithViewPager(mViewpager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id =item.getItemId();

        if (id== R.id.app_bar_search){
            Intent intent = new Intent(CustomerDashBoard.this, Searchfirst.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
