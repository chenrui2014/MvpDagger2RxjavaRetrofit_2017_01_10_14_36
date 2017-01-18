package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.component;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.BaseApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.module.LoginApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.presenter.LoginPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/17 15:15 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/17 15:15 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
@Singleton
@Component(modules = {BaseApiServiceModule.class, LoginApiServiceModule.class})
public interface LoginApiComponent {
//    void inject(LoginModule loginModule);
    void inject(LoginPresenter loginPresenter);
}
