package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.module;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.module.BaseDataLoadingModule;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.data.LoginApiService;

import javax.inject.Inject;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/13 10:37 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/13 10:37 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class LoginModule extends BaseDataLoadingModule {

    @Inject
    protected LoginApiService mLoginApiService;//这个地方不能动，必须放这里

    //登录
   public void login () {

//       Observable<LoginResult> loginResultObservable = mLoginApiService.login("admin",
//               "21232f297a57a5a743894a0e4a801fc3");
   }
}
