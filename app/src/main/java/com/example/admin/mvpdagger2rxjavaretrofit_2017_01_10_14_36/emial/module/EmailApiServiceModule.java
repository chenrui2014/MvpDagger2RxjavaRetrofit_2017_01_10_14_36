package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.module;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.emailService.EmailApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/9 11:43 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/9 11:43 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
@Module
public class EmailApiServiceModule {

    @Provides
    @Singleton
    public EmailApiService provideEmailService (Retrofit retrofit) {
        EmailApiService emailApiService = retrofit.create(EmailApiService.class);
        return emailApiService;
    }
}
