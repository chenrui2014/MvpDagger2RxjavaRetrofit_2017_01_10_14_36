package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.module;

import android.util.Log;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.emailService.EmailApiService;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.bean.LoginResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.data.LoginApiService;

import javax.inject.Inject;

import rx.Observable;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/13 10:37 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/13 10:37 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class LoginModule {

    @Inject
    protected LoginApiService mLoginApiService;//这个地方不能动，必须放这里

    @Inject
    protected EmailApiService mEmailApiService;

//    @Inject
//    protected Application mApplication;


    public LoginModule() {
//        DaggerLoginApiComponent.builder().build().inject(this);
//        DaggerBaseApiComponent.builder().build().inject(this);
//        DaggerApplicationComponent.builder().build().inject(this);
    }

    //登录
   public void login () {

       Log.e(" login e22222 "," loginapiservice222 " + mLoginApiService);

       Log.e(" Applica le222 "," ApplicationModule22 " + mEmailApiService);

//       Log.e(" Application "," Application " + mApplication);

       Observable<LoginResult> loginResultObservable = mLoginApiService.login("admin",
               "21232f297a57a5a743894a0e4a801fc3");

//       loginResultObservable.subscribeOn(Schedulers.io())
//               .observeOn(AndroidSchedulers.mainThread())
//               .subscribe(new LoginSubscriber<LoginResult>(loginPresenter));
   }

//    public class LoginSubscriber<T> extends BaseLoadingSubscriber<T> {
//
//        public LoginSubscriber(BaseLoadingStatus<T> baseLoadingStatus) {
//            super(baseLoadingStatus);
//        }
//    }
}
