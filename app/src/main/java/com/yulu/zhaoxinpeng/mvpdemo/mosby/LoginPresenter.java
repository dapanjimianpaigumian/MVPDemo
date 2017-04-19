package com.yulu.zhaoxinpeng.mvpdemo.mosby;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.yulu.zhaoxinpeng.mvpdemo.NetClient;
import com.yulu.zhaoxinpeng.mvpdemo.UICallBack;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/4/19.
 */

public class LoginPresenter extends MvpNullObjectBasePresenter<LoginView> {


    public void Login(String username, String passowrd) {

        getView().showProgressbar();

        NetClient.getInstance().Registe(username, passowrd).enqueue(new UICallBack() {
            @Override
            public void onFailureUI(Call call, IOException e) {
                getView().hideProgressbar();
                getView().showToast(e.getMessage());
            }

            @Override
            public void onResponseUI(Call call, String body) {
                getView().hideProgressbar();
                getView().showToast(body);
            }
        });
    }
}
