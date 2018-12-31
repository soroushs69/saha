package com.example.yegan.myapplication.menuPage.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.menuPage.adapter.CategoryMenuAdapter;
import com.example.yegan.myapplication.homePage.model.CategoryMenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.category_fragment, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);


        setUpMenuRecyclerView((RecyclerView) view.findViewById(R.id.category_list));
        viewPager.setAdapter(new SectionPagerAdapter(getFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        return view;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpMenuRecyclerView(RecyclerView recyclerView){

        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        CategoryMenuAdapter categoryMenuAdapter = new CategoryMenuAdapter(this.getContext(), setUpMenuList());
        recyclerView.setAdapter(categoryMenuAdapter);
    }

    public List<CategoryMenuItem> setUpMenuList(){
        List<CategoryMenuItem> data = new ArrayList<>();
        data.add(new CategoryMenuItem("دوبل برگر","همبرگر + پنیر پارمزان + گوجه فرنگی",  "17,000", "14,000 تومان", 15, 2));
        data.add(new CategoryMenuItem("فیش برگر","همبرگر + پنیر پارمزان + گوجه فرنگی",  "24,000", "21,000 تومان", 12, 2));
        data.add(new CategoryMenuItem("چیز برگر","همبرگر + پنیر پارمزان + گوجه فرنگی",  "12,000", "11,000 تومان", 17, 2));
        data.add(new CategoryMenuItem("فرایز برگر","همبرگر + پنیر پارمزان + گوجه فرنگی",  "14,000", "12,000 تومان", 17, 2));
        data.add(new CategoryMenuItem("بیگگگ برگر","همبرگر + پنیر پارمزان + گوجه فرنگی",  "26,000", "26,000 تومان", 12, 2));
        data.add(new CategoryMenuItem("برگر معمولی","همبرگر",  "14,000", "14,000 تومان", 12, 2));

        return  data;
    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FoodTypeListFragment();
                case 1:
                default:
                    return new SpecificTypeListFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "عمومی";
                case 1:
                default:
                    return "تخصصی";
            }
        }
    }



}
