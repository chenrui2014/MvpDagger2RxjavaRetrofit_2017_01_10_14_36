package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.component.DaggerBaseApiComponent;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.data.LoginApiService;

import javax.inject.Inject;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/12 14:22 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/12 14:22 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BasePresenter {

    @Inject
    public LoginApiService mLoginApiService;

    public BasePresenter() {
        DaggerBaseApiComponent.builder().build().inject(this);
    }
}
