package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.presenter;

import android.util.Log;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BaseListPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.rx.BaseLoadingSubscriber;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailListBean;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailListBean.EmailList;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.component.DaggerEmailApiComponent;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.emailService.EmailApiService;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/12 14:41 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/12 14:41 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class EmailPresenter extends BaseListPresenter<EmailList, EmailListBean> {

//    EmailStatus mEmailStatus;

//    public EmailPresenter(BaseLoadingStatus<DATA> baseLoadingStatus, EmailStatus<DATA> emailStatus) {
//        super(baseLoadingStatus);
//        mEmailStatus = emailStatus;
//    }

        @Inject
    protected EmailApiService mMailApiService;

    public EmailPresenter(BaseLoadingStatus<EmailListBean> baseLoadingStatus) {
        super(baseLoadingStatus);
//        mEmailStatus = emailStatus;
        DaggerEmailApiComponent.builder().build().inject(this);
    }

    @Override
    public void loadData() {
        super.loadData();
        Log.e(" load emailpresenter ","  load emailpresenter ");
        observ(0+"");
    }

    @Override
    public void loadMore(EmailList data) {
        super.loadMore(data);
        observ(data.getId());
    }

    private void observ (String id) {
        Observable<EmailListBean> emailObservable = mMailApiService.mailList(id, 10);
        emailObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseLoadingSubscriber<>(this));
    }

    @Override
    public void success(EmailListBean data) {
        super.success(data);
//        mEmailStatus.fillView(data);
    }


}
