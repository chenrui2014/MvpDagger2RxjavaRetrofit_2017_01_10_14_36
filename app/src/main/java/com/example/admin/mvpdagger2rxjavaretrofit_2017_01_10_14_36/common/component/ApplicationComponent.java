package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.component;


import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.ApplicationModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.BaseApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.BaseDataModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BasePresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.BaseActivity;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.BaseFragment;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.data.LoginApiService;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.module.LoginApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.module.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/28 11:17 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/28 11:17 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
@Singleton
@Component(modules = {ApplicationModule.class, BaseApiServiceModule.class, LoginApiServiceModule.class})
public interface ApplicationComponent {
    void inject(BasePresenter presenter);

    void inject(BaseDataModule baseDataModule);

    void inject(LoginApiService loginModule);

    void inject(LoginModule loginModule);

    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);

}
