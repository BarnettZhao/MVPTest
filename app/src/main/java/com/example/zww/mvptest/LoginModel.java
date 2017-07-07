package com.example.zww.mvptest;

/**
 * Created by zww on 2017/7/3.
 */

public class LoginModel implements ILoginModel {

    @Override
    public void login(final String phone, final String code, final IResult iResult) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (!"".equals(phone) && !"".equals(code)) {
                    iResult.success();
                } else {
                    iResult.error();
                }
            }
        }).start();
    }

    @Override
    public void toGetCode(String phone,IResult iResult) {
        if (!"".equals(phone)) {
            iResult.success();
        } else {
            iResult.error();
        }
    }
}
