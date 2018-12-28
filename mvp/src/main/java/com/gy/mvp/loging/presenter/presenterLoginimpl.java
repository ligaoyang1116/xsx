package com.gy.mvp.loging.presenter;

import android.util.Log;

import com.gy.mvp.api.Api;
import com.gy.mvp.loging.LoginActivity;
import com.gy.mvp.loging.model.IModelLogin;
import com.gy.mvp.loging.model.ModelLoginimpl;

public class presenterLoginimpl implements IpresenterLogin {

    private final ModelLoginimpl modelLoginimpl;
    LoginActivity logview;
    //构造器
    public presenterLoginimpl(LoginActivity logview) {
        //初始化model
        modelLoginimpl = new ModelLoginimpl();
        //初始化view
        this.logview=logview;
    }

    @Override
    public void getpreData(String name, String pswd) {
        //获取model数据
        modelLoginimpl.getModelData(Api.LOGINURL, name, pswd, new IModelLogin.ModelCallBack() {
           //登录失败
            @Override
            public void failed() {

                logview.showFailedMsg("登录失败");
            }

            @Override
            public void successl(String data) {
                Log.i("", "onStatus: "+data);
                logview.showSuccessMsg("登录成功");
                logview.jumpActivity();
            }
        });
    }
}
