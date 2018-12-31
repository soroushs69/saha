package com.example.yegan.myapplication.menuPage.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.menuPage.adapter.OfferAdapter;
import com.example.yegan.myapplication.homePage.model.RestaurantSliderItem;

import java.util.ArrayList;
import java.util.List;

public class OfferFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.offers_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.special_offer);
        setUpMenuRecyclerView(recyclerView);

        return view;

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpMenuRecyclerView(RecyclerView recyclerView){

        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 3));
        OfferAdapter sliderAdapter = new OfferAdapter(this.getContext(), setUpMenuList());
        recyclerView.setAdapter(sliderAdapter);
    }

    public List<RestaurantSliderItem> setUpMenuList(){
        List<RestaurantSliderItem> data = new ArrayList<>();
        data.add(new RestaurantSliderItem(R.drawable.food1,getString(R.string.restaurant_slide_item_1)));
        data.add(new RestaurantSliderItem(R.drawable.food2,getString(R.string.restaurant_slide_item_2)));
        data.add(new RestaurantSliderItem(R.drawable.food3,getString(R.string.restaurant_slide_item_3)));
        data.add(new RestaurantSliderItem(R.drawable.food_1,getString(R.string.restaurant_slide_item_1)));
        data.add(new RestaurantSliderItem(R.drawable.food_2,getString(R.string.restaurant_slide_item_2)));
        data.add(new RestaurantSliderItem(R.drawable.food_3,getString(R.string.restaurant_slide_item_3)));
        return  data;
    }
}
