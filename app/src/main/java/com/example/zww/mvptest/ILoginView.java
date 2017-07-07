package com.example.zww.mvptest;

/**
 * Created by zww on 2017/7/3.
 */

public interface ILoginView {
    /**
     *
     * @return获取手机号
     */
    String getPhone();

    /**
     *
     * @return获取验证码
     */
    String getCode();

    /**
     * 设置为获取验证码
     */
    void showGetCode();

    /**
     * 显示倒计时
     */
    void showTime();

    /**
     * Toast
     */
    void showToast(String msg);
}
