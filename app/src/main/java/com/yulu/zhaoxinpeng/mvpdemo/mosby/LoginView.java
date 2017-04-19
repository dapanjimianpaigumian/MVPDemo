package com.yulu.zhaoxinpeng.mvpdemo.mosby;


import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2017/4/19.
 */

public interface LoginView extends MvpView {

    void showProgressbar();

    void hideProgressbar();

    void showToast(String s);
}
