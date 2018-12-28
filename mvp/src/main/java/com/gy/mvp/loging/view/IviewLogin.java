package com.gy.mvp.loging.view;

public interface IviewLogin {
    //Toast形式提示
    public void showSuccessMsg(String msg);
    public void showFailedMsg(String msg);
    //加载提示框
    public void   showLoading();
    //隐藏加载提示框
    public void hiddenLoading();
    //页面跳转
    public void jumpActivity();
}
