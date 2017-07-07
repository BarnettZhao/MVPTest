package com.example.zww.mvptest;

import android.os.Handler;

/**
 * Created by zww on 2017/7/3.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginModel iLoginModel;
    private ILoginView iLoginView;
    private Handler handler = new Handler();

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.iLoginModel = new LoginModel();
    }

    public void login(){
        iLoginModel.login(iLoginView.getPhone(), iLoginView.getCode(), new IResult() {
            @Override
            public void success() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.showToast("登录成功");
                    }
                });
            }

            @Override
            public void error() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.showToast("登录失败");
                    }
                });
            }
        });
    }

    public void getCode(){
        iLoginModel.toGetCode(iLoginView.getPhone(), new IResult() {
            @Override
            public void success() {
                iLoginView.showTime();
                iLoginView.showToast("获取验证码成功");
            }

            @Override
            public void error() {
                iLoginView.showToast("获取验证码失败");
                iLoginView.showGetCode();
            }
        });
    }
}
