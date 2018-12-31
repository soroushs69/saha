package com.example.yegan.myapplication.menuPage.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.menuPage.adapter.FoodListAdapter;
import com.example.yegan.myapplication.homePage.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class HottestFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.hottest_fragment, container, false);
        setUpMenuRecyclerView((RecyclerView)view.findViewById(R.id.hottest_list));
        setUpMenuRecyclerView((RecyclerView)view.findViewById(R.id.best_seller_list));

        return view;

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpMenuRecyclerView(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false));
        FoodListAdapter foodListAdapter = new FoodListAdapter(this.getActivity(), setUpMenuList());
        recyclerView.setAdapter(foodListAdapter);
    }

    public List<FoodItem> setUpMenuList(){
        List<FoodItem> data = new ArrayList<>();
        data.add(new FoodItem("هات داگ","تاکسی",  "20,000", "23,000 تومان", 12, 2, R.drawable.food1));
        data.add(new FoodItem("همبرگر","خانه برگر", "30,000", "40,000 تومان",30, 2, R.drawable.food2));
        data.add(new FoodItem("سمبوسه","معین درباری", "50,000", "58,000 تومان", 20, 2, R.drawable.food3));
        data.add(new FoodItem("دیزی","اعیونی", "1800", "1000", 45, 2, R.drawable.food_1));
        data.add(new FoodItem("همبرگر","آس برگر", "1800", "1000", 12, 2, R.drawable.food_2));
        data.add(new FoodItem("اسپاگتی","پای", "1800", "1000", 12, 2, R.drawable.food_3));
        data.add(new FoodItem("لازانیا","ایران ایتالیا", "1800", "1000", 12, 2, R.drawable.food_4));
        return  data;
    }
}
