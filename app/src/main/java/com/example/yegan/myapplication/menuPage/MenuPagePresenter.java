package com.example.yegan.myapplication.menuPage;

public class MenuPagePresenter implements Content.Presenter {


    Content.View view;

    public MenuPagePresenter(Content.View view){
        this.view = view;
        initPresenter();
    }

    private void initPresenter() {

        view.initView();
    }

}
