package com.example.yegan.myapplication.restuarantPage;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.menuPage.adapter.FoodListAdapter;
import com.example.yegan.myapplication.homePage.model.FoodItem;

import java.util.ArrayList;
import java.util.List;


public class RestuarantPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{


    ListView listView;

    RecyclerView rice, salad, kebab;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        setContentView(R.layout.activity_restuarant_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


//        findViewById(R.id.whole_item).setY(200);
        String[] values = new String[] { "کبابی",
                "پلویی",
                "سالاد"
        };

        listView = findViewById(R.id.side_bar);

        salad = findViewById(R.id.salad);
        rice = findViewById(R.id.rice);
        kebab = findViewById(R.id.kebab);

        Log.i("errory", salad.toString());
        setUpRecyclerView(salad);
        setUpRecyclerView(rice);
        setUpRecyclerView(kebab);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, android.R.id.text1, values);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.getSelectedItem();

        if(listView != null)
            listView.setAdapter(adapter);

        final NestedScrollView scrollView = findViewById(R.id.scrollView);




        final TextView riceText = findViewById(R.id.riceText);
        final TextView saladText = findViewById(R.id.saladText);
        final TextView kababText = findViewById(R.id.kebabText);
        int[] location = new int[2];
        final int riceY , saladY, kababY;

        riceText.getLocationOnScreen(location);
        riceY = location[1];
        Log.i("eeee", "rice: " + location[1]);


        kababText.getLocationOnScreen(location);
        kababY = location[1];
        Log.i("eeee", "kabab: " + location[1]);


        saladText.getLocationOnScreen(location);
        saladY = location[1];

        Log.i("eeee", "salad: " + location[1]);







        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int[] l = new int[2];
                final int riceYy , saladYy, kebabYy;
                kababText.getLocationOnScreen(l);
                Log.i("errory" , "kebab : " + l[1]);
                kebabYy = l[1];
                riceText.getLocationOnScreen(l);
                Log.i("errory" , "rice : " + l[1]);
                riceYy = l[1];
                saladText.getLocationOnScreen(l);
                Log.i("errory" , "salad : " + l[1]);
                saladYy = l[1];



                switch (position){
                    case 0:
                        Log.i("errory",  "POSITION" + position + ":" + kebabYy);
                        scrollView.scrollTo(0, kebabYy);
                        break;
                    case 1:

                        Log.i("errory",  "POSITION" + position + ":" + riceYy);
                        scrollView.scrollTo(0,riceYy);
                        break;
                    case 2:

                        Log.i("errory",  "POSITION" + position + ":" + saladYy);
                        scrollView.scrollTo(0, saladYy);
                        break;
                }


            }


        });


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
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
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



    //food item

    public void setUpRecyclerView(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        FoodListAdapter foodListAdapter = new FoodListAdapter(this, setUpMenuList());
        recyclerView.setAdapter(foodListAdapter);

    }

    public List<FoodItem> setUpMenuList(){
        List<FoodItem> data = new ArrayList<>();
        data.add(new FoodItem("هات داگ","تاکسی",  "20,000", "23,000 تومان", 12, 2, R.drawable.food1));
        data.add(new FoodItem("همبرگر","خانه برگر", "30,000", "40,000 تومان",30, 2, R.drawable.food2));
        data.add(new FoodItem("چلو کباب","معین درباری", "50,000", "58,000 تومان", 20, 2, R.drawable.food3));
        data.add(new FoodItem("چلو کباب","معین درباری", "1800", "1000", 45, 2, R.drawable.food1));
        data.add(new FoodItem("چلو کباب","معین درباری", "1800", "1000", 12, 2, R.drawable.food2));
        data.add(new FoodItem("چلو کباب","معین درباری", "1800", "1000", 12, 2, R.drawable.food3));
        data.add(new FoodItem("چلو کباب","معین درباری", "1800", "1000", 12, 2, R.drawable.food1));
        return  data;
    }

}
