package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.presenter;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BaseLoadingPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.viewAction.LoginStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/13 10:20 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/13 10:20 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class LoginPresenter<T> extends BaseLoadingPresenter<T> {

    LoginStatus<T> mLoginStatus;

    public LoginPresenter(BaseLoadingStatus<T> baseLoadingStatus, LoginStatus<T> loginStatus) {
        super(baseLoadingStatus);
        mLoginStatus = loginStatus;
    }

    @Override
    public void loadData() {
        super.loadData();
        mLoginStatus.login();
    }
}
