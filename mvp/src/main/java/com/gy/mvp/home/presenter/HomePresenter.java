package com.gy.mvp.home.presenter;

import com.gy.mvp.MainActivity;
import com.gy.mvp.api.Api;
import com.gy.mvp.home.moudle.HomeModel;
public class HomePresenter implements IHomePresenter,HomeModel.SetMoudleFace {
    private final HomeModel homeModel;
    MainActivity view;

    public HomePresenter(MainActivity view) {
        //初始化modle
        homeModel = new HomeModel(this);
        //初始化view
        this.view=view;
    }


    @Override
    public void getPresenterData() {
        //调用modle里的方法
        homeModel.getModelData(Api.HOMEURL);
    }


    @Override
    public void successfulldata(String t) {
        view.getMviewData(t);
    }

    @Override
    public void ereodata() {
        view.getMviewData("加载失败。。。");
    }
}
