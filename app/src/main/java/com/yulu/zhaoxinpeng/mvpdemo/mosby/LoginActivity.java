package com.yulu.zhaoxinpeng.mvpdemo.mosby;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.yulu.zhaoxinpeng.mvpdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends MvpActivity<LoginView, LoginPresenter> implements LoginView {

    @BindView(R.id.login_username)
    EditText mLoginUsername;
    @BindView(R.id.login_password)
    EditText mLoginPassword;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.login_prb)
    ProgressBar mLoginPrb;
    private Unbinder bind;
    private String username;
    private String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bind = ButterKnife.bind(this);

        mLoginUsername.addTextChangedListener(mTextWatcher);
        mLoginPassword.addTextChangedListener(mTextWatcher);
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            username = mLoginUsername.getText().toString();
            password = mLoginPassword.getText().toString();

            mLoginBtn.setEnabled(true);
        }
    };

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    //-------------------------------视图接口操作-----------------------------------------
    @Override
    public void showProgressbar() {
        mLoginPrb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        mLoginPrb.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.login_btn)
    public void onViewClicked() {
        getPresenter().Login(username, password);
    }
}
