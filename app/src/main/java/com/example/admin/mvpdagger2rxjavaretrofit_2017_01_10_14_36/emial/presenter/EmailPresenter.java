package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.presenter;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BaseLoadingPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.status.EmailStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/12 14:41 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/12 14:41 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class EmailPresenter<T> extends BaseLoadingPresenter<T> {

    EmailStatus<T> mEmailStatus;

    public EmailPresenter(BaseLoadingStatus<T> baseLoadingStatus, EmailStatus<T> emailStatus) {
        super(baseLoadingStatus);
        mEmailStatus = emailStatus;
    }

    @Override
    public void success(T data) {
        super.success(data);
        mEmailStatus.fillView(data);
    }
}
