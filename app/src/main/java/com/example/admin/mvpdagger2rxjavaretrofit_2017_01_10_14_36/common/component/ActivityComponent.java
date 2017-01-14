package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.component;

import android.app.Activity;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.ActivityModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.PerActivity;

import dagger.Component;

/**
 * Created by Arron on 16/7/25.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
