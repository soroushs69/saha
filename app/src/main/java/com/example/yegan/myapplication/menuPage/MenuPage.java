package com.example.yegan.myapplication.menuPage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.menuPage.fragment.CategoryFragment;
import com.example.yegan.myapplication.menuPage.fragment.HottestFragment;
import com.example.yegan.myapplication.menuPage.fragment.OfferFragment;
import com.example.yegan.myapplication.menuPage.fragment.RestuarantFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MenuPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Content.View{


    @BindView(R.id.restuarant) Button restuarant;
    @BindView(R.id.category) Button category;
    @BindView(R.id.offer) Button offer;
    @BindView(R.id.hottest) Button hottest;
    @BindView(R.id.video) Button video;

    Button current;


    Content.Presenter presenter;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        setContentView(R.layout.activity_menu_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        presenter = new MenuPagePresenter(this);



    }


    @Override
    public void initView() {
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        String id = extras.getString("FRAGMENT_ID");
        Fragment myfragment;
        FragmentManager fm = getFragmentManager();
        switch(id){
            case "com.example.yegan.myapplication:id/restuarant":
                restuarant.setBackgroundResource(R.drawable.home_page_button_round_clicked);
                myfragment = new RestuarantFragment();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_switch, myfragment);
                fragmentTransaction.commit();
                current = restuarant;
                break;
            case "com.example.yegan.myapplication:id/category":
                category.setBackgroundResource(R.drawable.home_page_button_round_clicked);
//                android.support.v4.app.Fragment myfragment1 = new CategoryFragment();
//                FragmentTransaction fragmentTransaction2 = fm.beginTransaction();
//                fragmentTransaction2.replace(R.id.fragment_switch, myfragment1);
//                fragmentTransaction2.commit();

                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction11 = fragmentManager.beginTransaction();
                CategoryFragment fragment = new CategoryFragment();
                fragmentTransaction11.replace(R.id.fragment_switch, fragment);
                fragmentTransaction11.commit();

                current = category;
                break;
            case "com.example.yegan.myapplication:id/offer":
                offer.setBackgroundResource(R.drawable.home_page_button_round_clicked);
                myfragment = new OfferFragment();
                FragmentTransaction fragmentTransaction111 = fm.beginTransaction();
                fragmentTransaction111.replace(R.id.fragment_switch, myfragment);
                fragmentTransaction111.commit();
                current = offer;
                break;
            case "com.example.yegan.myapplication:id/hottest":
                hottest.setBackgroundResource(R.drawable.home_page_button_round_clicked);
                myfragment = new HottestFragment();
                FragmentTransaction fragmentTransaction1 = fm.beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_switch, myfragment);
                fragmentTransaction1.commit();
                current = hottest;
                break;
            case "com.example.yegan.myapplication:id/video":
                video.setBackgroundResource(R.drawable.home_page_button_round_clicked);
                current = video;
                break;

        }

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
//        getMenuInflater().inflate(R.menu.menu_page, menu);

        /////////////test s
        getMenuInflater().inflate(R.menu.home_page, menu);
        ///////////test e
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ////////// test s
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.action_settings) {
            drawer.openDrawer(GravityCompat.END);
        }
        /////////// test e
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.favorite) {

        } else if (id == R.id.home) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void menuFragment(View view){

        String viewId = view.getResources().getResourceName(view.getId());


        current.setBackgroundResource(R.drawable.home_page_button_round);
        view.setBackgroundResource(R.drawable.home_page_button_round_clicked);
        current = (Button)view;
        FragmentManager fm = getFragmentManager();

//        Fragment fragment = getSupportFragmentManager().findFragmentByTag("");
//        if(fragment != null)
//            getSupportFragmentManager().beginTransaction().remove(fragment).commit();

        switch(viewId){
            case "com.example.yegan.myapplication:id/restuarant":
                Fragment myfragment = new RestuarantFragment();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_switch, myfragment);
                fragmentTransaction.commit();
                break;
            case "com.example.yegan.myapplication:id/category":
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction11 = fragmentManager.beginTransaction();
                CategoryFragment fragment = new CategoryFragment();
                fragmentTransaction11.replace(R.id.fragment_switch, fragment);
                fragmentTransaction11.commit();
                break;
            case "com.example.yegan.myapplication:id/offer":
                myfragment = new OfferFragment();
                FragmentTransaction fragmentTransaction111 = fm.beginTransaction();
                fragmentTransaction111.replace(R.id.fragment_switch, myfragment);
                fragmentTransaction111.commit();
                break;
            case "com.example.yegan.myapplication:id/hottest":
                myfragment = new HottestFragment();
                FragmentTransaction fragmentTransaction1 = fm.beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_switch, myfragment);
                fragmentTransaction1.commit();
                break;
            case "com.example.yegan.myapplication:id/video":

                break;

        }


    }
}
