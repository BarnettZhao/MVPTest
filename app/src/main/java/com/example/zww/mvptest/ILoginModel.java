package com.example.zww.mvptest;

/**
 * Created by zww on 2017/7/3.
 */

public interface ILoginModel {

    /**
     *
     * @param phone 手机号
     * @param code 验证码
     */
    void login(String phone,String code,IResult iResult);

    /**
     *
     * @param phone 手机号
     */
    void toGetCode(String phone,IResult iResult);

}
