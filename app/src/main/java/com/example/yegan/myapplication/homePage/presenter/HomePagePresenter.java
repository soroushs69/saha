package com.example.yegan.myapplication.homePage.presenter;

import android.content.Intent;
import android.view.View;

import com.example.yegan.myapplication.homePage.content.HomePageContent;
import com.example.yegan.myapplication.menuPage.MenuPage;

public class HomePagePresenter implements HomePageContent.PresenterHome {

    private HomePageContent.ViewHome view;

    public HomePagePresenter(HomePageContent.ViewHome view){
        this.view = view;
        initPresenter();

    }

    private void initPresenter() {
        //init model if you want
        view.initView();
    }

    @Override
    public void fragmentClick(View view) {
        String viewId = view.getResources().getResourceName(view.getId());
        Intent intent = new Intent(view.getContext(), MenuPage.class);
        intent.putExtra("FRAGMENT_ID", viewId);
        view.getContext().startActivity(intent);
    }
}
