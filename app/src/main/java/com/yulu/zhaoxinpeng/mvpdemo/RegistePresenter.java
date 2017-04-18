package com.yulu.zhaoxinpeng.mvpdemo;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/4/18.
 */

public class RegistePresenter {

    public RegisteInterface mRegisteInterface;

    public RegistePresenter(RegisteInterface registeInterface) {
        this.mRegisteInterface = registeInterface;
    }

    public void Register(String username, String passowrd) {

        mRegisteInterface.showProgressbar();

        NetClient.getInstance().Registe(username, passowrd).enqueue(new UICallBack() {
            @Override
            public void onFailureUI(Call call, IOException e) {
                mRegisteInterface.hideProgressbar();
                mRegisteInterface.showToast(e.getMessage());
            }

            @Override
            public void onResponseUI(Call call, String body) {
                mRegisteInterface.hideProgressbar();
                mRegisteInterface.showToast(body);
            }
        });
    }
}
