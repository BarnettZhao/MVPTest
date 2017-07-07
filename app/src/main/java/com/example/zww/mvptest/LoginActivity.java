package com.example.zww.mvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zww.mvptest.viewinject.annotation.ViewInject;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    @ViewInject(R.id.et_login_phone)
    private EditText phoneInput;
    @ViewInject(R.id.et_login_verification_code)
    private EditText codeInput;
    @ViewInject(R.id.tv_login_get_code)
    private TextView getCodeTv;
    @ViewInject(R.id.tv_login_confirm)
    private TextView login;


    private DownTimeUtil downTimeUtil;
    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewInjectUtils.inject(this);
        init();
    }

    private void init() {
        loginPresenter = new LoginPresenter(this);

        downTimeUtil = new DownTimeUtil(this);
        downTimeUtil.initCountDownTime(getCodeTv);

        getCodeTv.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public String getPhone() {
        return phoneInput.getText().toString();
    }

    @Override
    public String getCode() {
        return codeInput.getText().toString();
    }

    @Override
    public void showGetCode() {
        downTimeUtil.countDownTimer.cancel();
        getCodeTv.setText("GET CODE");
    }

    @Override
    public void showTime() {
        downTimeUtil.countDownTimer.start();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login_get_code://点击获取验证码
                loginPresenter.getCode();
                break;
            case R.id.tv_login_confirm://登录
                loginPresenter.login();
                break;
        }
    }
}
