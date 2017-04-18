package com.yulu.zhaoxinpeng.mvpdemo;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/4/18.
 */

public class NetClient {
    public static NetClient mNetClient;
    private final OkHttpClient mOkHttpClient;

    public NetClient() {
        mOkHttpClient = new OkHttpClient.Builder().build();
    }

    public static NetClient getInstance() {
        if (mNetClient == null) {
            mNetClient = new NetClient();
        }
        return mNetClient;
    }

    public Call Registe(String username, String password) {
        RequestBody mRequestBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        Request mRequest = new Request.Builder()
                .url(NetApi.BASE_URL + NetApi.REGISTER)
                .post(mRequestBody)
                .build();

        return mOkHttpClient.newCall(mRequest);
    }
}
