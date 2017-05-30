package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.module;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.testService.TestApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 90678 on 2017/5/18.
 */

@Module
public class TestApiServiceModule {

    @Provides
    @Singleton
    public TestApiService provideTestApiServiceModule() {
        return new TestApiService();
    }
}
