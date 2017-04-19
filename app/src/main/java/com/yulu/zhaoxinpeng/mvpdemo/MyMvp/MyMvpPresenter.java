package com.yulu.zhaoxinpeng.mvpdemo.MyMvp;

/**
 * Created by Administrator on 2017/4/19.
 */

public class MyMvpPresenter <V extends MyMvpView>{

    private V v;

    //经常用的View 接口，所以卸载父类方法，方便调用
    public V getView(){
        if (v==null) {

        }
        return v;
    }
}
