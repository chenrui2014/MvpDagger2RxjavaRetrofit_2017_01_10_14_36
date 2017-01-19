package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.presenter;

import android.util.Log;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BaseLoadingPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.rx.BaseLoadingSubscriber;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.bean.LoginResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.component.DaggerLoginApiComponent;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.data.LoginApiService;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.viewAction.LoginStatus;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/13 10:20 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/13 10:20 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class LoginPresenter extends BaseLoadingPresenter<LoginResult> {

    LoginStatus<LoginResult> mLoginStatus;

    @Inject
    protected LoginApiService mLoginApiService;//这个地方不能动，必须放这里

//    @Inject
//    protected MailApiService mMailApiService;

    public LoginPresenter(BaseLoadingStatus<LoginResult> baseLoadingStatus) {
        super(baseLoadingStatus);
//        mLoginStatus = loginStatus;
        DaggerLoginApiComponent.builder().build().inject(this);
    }

//    public LoginPresenter() {
//        DaggerLoginApiComponent.builder().build().inject(this);
//    }

    @Override
    public void loadData() {
        super.loadData();
//        mLoginStatus.login();
        login();
    }

    public void login() {
        Log.e(" logi s333333333 "," loginapi333333 " + mLoginApiService);

//        Log.e(" Applicati333333 "," Applicat33333 " + mMailApiService);

//        Observable<LoginResult> loginResultObservable = mLoginApiService.login("admin",
//                "21232f297a57a5a743894a0e4a801fc3");
        Observable<LoginResult> loginResultObservable = mLoginApiService.login("10082",
                "e10adc3949ba59abbe56e057f20f883e");
        loginResultObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseLoadingSubscriber<>(this));
    }
}
