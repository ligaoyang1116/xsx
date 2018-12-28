package com.gy.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gy.mvp.home.presenter.HomePresenter;
import com.gy.mvp.home.view.IHomeView;

public class MainActivity extends AppCompatActivity implements IHomeView {

    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        t1 = findViewById(R.id.t1);
        //初始化presenter
        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.getPresenterData();
    }

    @Override
    public void getMviewData(String data) {
        t1.setText(data);
    }
}
