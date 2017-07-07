package com.example.zww.mvptest;

/**
 * Created by zww on 2017/7/6.
 */

public interface IResult {
    /**
     * 登陆成功
     */
    void success();

    /**
     * 登录失败
     */
    void error();
}
