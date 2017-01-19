package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.component;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.BaseApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BasePresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.activity.BaseActivity;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.activity.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/17 11:11 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/17 11:11 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
@Singleton
@Component(modules = {BaseApiServiceModule.class})
public interface BaseApiComponent {

//    void inject(LoginApiService loginApiService);

//    void inject(LoginModule loginModule);

    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);

    void inject(BasePresenter basePresenter);
}
