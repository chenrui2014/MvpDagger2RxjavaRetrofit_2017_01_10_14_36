package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.component;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.BaseApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.module.EmailApiServiceModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.presenter.EmailPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/18 17:44 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/18 17:44 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
@Singleton
@Component (modules = {BaseApiServiceModule.class, EmailApiServiceModule.class})
public interface EmailApiComponent {
    void inject(EmailPresenter emailPresenter);
}
