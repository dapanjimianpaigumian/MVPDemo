package com.yulu.zhaoxinpeng.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements RegisteInterface {

    @BindView(R.id.register_username)
    EditText mRegisterUsername;
    @BindView(R.id.register_password)
    EditText mRegisterPassword;
    @BindView(R.id.register_btn)
    Button mRegisterBtn;
    @BindView(R.id.register_prb)
    ProgressBar mRegisterPrb;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRegisterUsername.addTextChangedListener(mTextWatcher);
        mRegisterPassword.addTextChangedListener(mTextWatcher);
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
            username = mRegisterUsername.getText().toString();
            password = mRegisterPassword.getText().toString();

            mRegisterBtn.setEnabled(true);
        }
    };

    @OnClick(R.id.register_btn)
    public void onViewClicked() {
        new RegistePresenter(this).Register(username, password);
    }

    @Override
    public void showProgressbar() {
        mRegisterPrb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        mRegisterPrb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
