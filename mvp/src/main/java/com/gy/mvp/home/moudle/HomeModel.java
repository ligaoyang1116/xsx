package com.gy.mvp.home.moudle;

import com.gy.mvp.utils.MyTask;

public class HomeModel implements IHomeModel{

    //实现接口
    SetMoudleFace setMoudleFace;
    public HomeModel(SetMoudleFace setMoudleFace) {
        this.setMoudleFace=setMoudleFace;
    }

    @Override
    public void getModelData(String url) {
        new MyTask<String>(url,"GET").setTaskListener(new MyTask.TaskListeners() {
            @Override
            public void result(String t) {
                //实现接口方法
                if (t!=null){
                    setMoudleFace.successfulldata(t);
                }else{
                    setMoudleFace.ereodata();
                }
            }
        }).execute();
    }
    //定义接口
    public interface SetMoudleFace{
        //接口方法
        //成功
        void successfulldata(String t);
        void ereodata();
    }
}
