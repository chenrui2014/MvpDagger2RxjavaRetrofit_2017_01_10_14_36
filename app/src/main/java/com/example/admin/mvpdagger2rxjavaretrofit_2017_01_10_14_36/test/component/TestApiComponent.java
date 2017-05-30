package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.component;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.BaseApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.module.TestApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.presenter.TestPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 90678 on 2017/5/18.
 */

@Singleton
@Component(modules = {BaseApiServiceModule.class, TestApiServiceModule.class})
public interface TestApiComponent {
    void inject(TestPresenter testApiServiceModule);
}
