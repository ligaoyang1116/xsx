package com.gy.mvp.loging.model;

import com.gy.mvp.utils.MyTaskP;

public class ModelLoginimpl implements IModelLogin{

    @Override
    public void getModelData(final String url, final String name,final String pswd,final ModelCallBack modelCallBack) {
        new Runnable(){
            @Override
            public void run() {
                new MyTaskP<String>(url,name,pswd).setTaskListener(new MyTaskP.TaskListeners() {
                    @Override
                    public void result(String t) {
                        if (t!=null){
                            modelCallBack.successl(t);
                        }else {
                            modelCallBack.failed();
                        }
                    }
                } ).execute();
            }
        }.run();
    }
}
