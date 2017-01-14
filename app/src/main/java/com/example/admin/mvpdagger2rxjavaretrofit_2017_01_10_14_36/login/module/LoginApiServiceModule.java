package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.module;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.data.LoginApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/13 18:02 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/13 18:02 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
@Module
public class LoginApiServiceModule {
    @Provides
    @Singleton
    protected LoginApiService provideLoginService(Retrofit build) {
        return build.create(LoginApiService.class);
    }
}
