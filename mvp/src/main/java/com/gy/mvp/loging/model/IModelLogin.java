package com.gy.mvp.loging.model;

public interface IModelLogin {
    void getModelData(String url,String name,String pswd,ModelCallBack modelCallBack);
    //定义接口
    public  interface ModelCallBack{
        //接口方法
        void failed();
        void successl(String data);
    }
}
