package com.example.yegan.myapplication.homePage.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.homePage.adapter.RestuarantMenuAdapter;
import com.example.yegan.myapplication.homePage.adapter.SliderAdapter;
import com.example.yegan.myapplication.homePage.content.HomePageContent;
import com.example.yegan.myapplication.homePage.model.RestaurantSliderItem;
import com.example.yegan.myapplication.homePage.model.RestuarantItem;
import com.example.yegan.myapplication.homePage.presenter.HomePagePresenter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomePageContent.ViewHome{

    RecyclerView sliderRecyclerView, menuRecyclerView;
    HomePagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        ///ss///drawer.setDrawerListener(toggle);
        toggle.syncState();

        presenter = new HomePagePresenter(this);

        setSliderRecyclerView();


        ///ss1 s///
        //setUpMenuRecyclerView();
        ///ss1 e///


        //////////////////test s
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        final NavigationView navigationViewRight = (NavigationView) findViewById(R.id.nav_view_right);
        navigationViewRight.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

//                if (id == R.id.nav_camera_right) {
//                    // Handle the camera action
//                } else if (id == R.id.nav_gallery_right) {
//
//                } else if (id == R.id.nav_slideshow_right) {
//
//                } else if (id == R.id.nav_manage_right) {
//
//                } else if (id == R.id.nav_share_right) {
//
//                } else if (id == R.id.nav_send_right) {
//
//                }

                Toast.makeText(MainActivity.this, "Handle from navigation right", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.END);
                return true;

            }
        });

        //////////////////////test e
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        ////////////test s
        else if(drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        }
        /////////////test e

        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ///////////test s
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.action_settings) {
            drawer.openDrawer(GravityCompat.END);
        }
        ///////////test e
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

    //نمایش اسلایدر صفحه اصلی //
    public void setSliderRecyclerView() {
        sliderRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SliderAdapter sliderAdapter = new SliderAdapter(this.setUpMenuSliderList());
        sliderRecyclerView.setAdapter(sliderAdapter);
    }

    //مقداردهی لیست اسلایدر صفحه اصلی //
    public List<RestaurantSliderItem> setUpMenuSliderList() {
        List<RestaurantSliderItem> data = new ArrayList<>();
        data.add(new RestaurantSliderItem(R.drawable.food1,getString(R.string.restaurant_slide_item_1)));
        data.add(new RestaurantSliderItem(R.drawable.slider_image_2,getString(R.string.restaurant_slide_item_2)));
        data.add(new RestaurantSliderItem(R.drawable.slider_image_4,getString(R.string.restaurant_slide_item_3)));
        data.add(new RestaurantSliderItem(R.drawable.food_13,getString(R.string.restaurant_slide_item_4)));
        data.add(new RestaurantSliderItem(R.drawable.food_13,getString(R.string.restaurant_slide_item_5)));
        return data;
    }


///ss1 s///
//    public void setUpMenuRecyclerView(){
//        menuRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        RestuarantMenuAdapter restuarantMenuAdapter = new RestuarantMenuAdapter(this, setUpMenuList());
//        menuRecyclerView.setAdapter(restuarantMenuAdapter);
//    }
///ss1 e///

    public static List<RestuarantItem> setUpMenuList(){
        List<RestuarantItem> data = new ArrayList<>();
        data.add(new RestuarantItem("کی اف سی","سوخاری", 4, R.drawable.logo_2, R.drawable.food_13));
        data.add(new RestuarantItem("شبدیز","برگر - پیتزا", 4, R.drawable.logo_3, R.drawable.food_12));
        data.add(new RestuarantItem("مک دونالد","برگر", 4, R.drawable.logo_4, R.drawable.food_2));
        data.add(new RestuarantItem("تاکسی فود","فست فود", 4, R.drawable.logo_5, R.drawable.food_6));
        data.add(new RestuarantItem("چیلی چیز","برگر - پیتزا - پاستا", 4, R.drawable.logo_6, R.drawable.food_5));
        data.add(new RestuarantItem("سید و پسران","ایرانی", 4, R.drawable.logo_7, R.drawable.food_10));
        data.add(new RestuarantItem("دنیای مکزیکی","مکزیکی", 4, R.drawable.logo_8, R.drawable.food_11));
        data.add(new RestuarantItem("اژدر","برگر", 4, R.drawable.icon3, R.drawable.food_3));
        data.add(new RestuarantItem("پسران کریم","ایرانی - سنتی", 4, R.drawable.icon1, R.drawable.food_1));
        return  data;


    }

    @Override
    public void initView() {
        sliderRecyclerView = findViewById(R.id.slider_recycler_view);
        ///ss1 s///
        //menuRecyclerView = findViewById(R.id.restuarant_menu);
        ///ss1 e///

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void menuFragment(View view){
        presenter.fragmentClick(view);
    }
}
