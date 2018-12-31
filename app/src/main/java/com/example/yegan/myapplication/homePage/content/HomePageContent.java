package com.example.yegan.myapplication.homePage.content;

public interface HomePageContent {

    interface ViewHome{
        void initView();
    }

    interface PresenterHome {
        void fragmentClick(android.view.View view);
    }

}
