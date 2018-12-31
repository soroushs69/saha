package com.example.yegan.myapplication.menuPage.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.homePage.adapter.RestuarantMenuAdapter;
import com.example.yegan.myapplication.homePage.view.MainActivity;
import com.example.yegan.myapplication.restuarantPage.RestuarantPage;

public class RestuarantFragment extends Fragment implements RestuarantMenuAdapter.ItemClickListener{

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.restuarant_fragment, container, false);
        ///ss1 s///
        setUpMenuRecyclerView((RecyclerView)view.findViewById(R.id.restuarant_menu));
        ///ss1 e///
        return view;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpMenuRecyclerView(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        RestuarantMenuAdapter restuarantMenuAdapter = new RestuarantMenuAdapter(this.getActivity(), MainActivity.setUpMenuList());
        recyclerView.setAdapter(restuarantMenuAdapter);
        restuarantMenuAdapter.setClickListener(this);

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onItemClick(View view, int position) {
//        Log.i("yeganeerror", view.toString());
//        Intent i = new Intent(this.getContext(), RestuarantPage.class);
//        startActivity(i);
    }

}