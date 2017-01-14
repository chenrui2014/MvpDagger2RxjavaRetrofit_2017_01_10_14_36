package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.data;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.bean.LoginResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/12 13:59 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/12 13:59 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface LoginApiService {

    //登录
    @FormUrlEncoded
    @POST("api/Login")
    Observable<LoginResult> login(@Field("usercode") String userCode, @Field("password") String password);

}
