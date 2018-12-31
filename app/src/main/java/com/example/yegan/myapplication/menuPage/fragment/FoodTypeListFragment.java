package com.example.yegan.myapplication.menuPage.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.menuPage.adapter.FoodTypeAdapter;
import com.example.yegan.myapplication.homePage.model.FoodTypeItem;

import java.util.ArrayList;
import java.util.List;

public class FoodTypeListFragment extends Fragment {


    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.food_type_fragment, container, false);
        setUpMenuRecyclerView((RecyclerView)view.findViewById(R.id.food_type_fragment_recycle_view));

        return view;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpMenuRecyclerView(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        FoodTypeAdapter foodListAdapter = new FoodTypeAdapter(this.getContext(), setUpMenuList());
        recyclerView.setAdapter(foodListAdapter);
    }

    public List<FoodTypeItem> setUpMenuList(){
        List<FoodTypeItem> data = new ArrayList<>();
        data.add(new FoodTypeItem(R.drawable.ic_hamburger, "همبرگر"));
        data.add(new FoodTypeItem(R.drawable.ic_pizza, "پیتزا"));
        data.add(new FoodTypeItem(R.drawable.ic_noodles, "چینی"));
        data.add(new FoodTypeItem(R.drawable.ic_cheers, "نوشیدنی"));
        return  data;
    }
}
