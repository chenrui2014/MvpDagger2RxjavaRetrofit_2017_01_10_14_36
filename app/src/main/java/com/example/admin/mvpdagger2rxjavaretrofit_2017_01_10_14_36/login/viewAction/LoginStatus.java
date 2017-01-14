package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.viewAction;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/13 10:21 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/13 10:21 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface LoginStatus<T> extends BaseLoadingStatus<T> {
    void login();
}
