package com.yulu.zhaoxinpeng.mvpdemo.MyMvp;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/4/19.
 */

public abstract class MyMvpActivity <P extends MyMvpPresenter,V extends MyMvpView>
        extends AppCompatActivity implements MyMvpView{

    //创建业务类，一定要实现
    public abstract P createPresenter();

    private P p;

    //经常要用到业务类
    public P getPresenter(){
        return p;
    }
}