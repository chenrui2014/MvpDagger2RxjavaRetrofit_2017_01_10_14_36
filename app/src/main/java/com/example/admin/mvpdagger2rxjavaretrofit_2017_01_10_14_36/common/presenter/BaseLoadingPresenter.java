package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/12 14:23 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/12 14:23 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseLoadingPresenter<DATA> implements BaseLoadingStatus<DATA> {

    protected BaseLoadingStatus<DATA> mBaseLoadingStatus;

    public BaseLoadingPresenter(BaseLoadingStatus<DATA> baseLoadingStatus) {
        mBaseLoadingStatus = baseLoadingStatus;
    }

    @Override
    public void loadData() {
//        mBaseLoadingStatus.loadData();
    }

    @Override
    public void startLoad() {
        mBaseLoadingStatus.startLoad();
    }

    @Override
    public void loading() {
        mBaseLoadingStatus.loading();
    }

    @Override
    public void success(DATA data) {
        mBaseLoadingStatus.success(data);
        //complete();
    }

    @Override
    public void empty() {
        mBaseLoadingStatus.empty();
        //complete();
    }

    @Override
    public void failure(int code, String msg) {
        mBaseLoadingStatus.failure(code, msg);
        //complete();
    }

    @Override
    public void error(String msg) {
        mBaseLoadingStatus.error(msg);
        //complete();
    }

    @Override
    public void complete() {
        mBaseLoadingStatus.complete();
    }

    @Override
    public void reLoad() {
        mBaseLoadingStatus.reLoad();
    }

    @Override
    public void offLine() {
        mBaseLoadingStatus.offLine();
        //complete();
    }

    @Override
    public void unLogin() {
        mBaseLoadingStatus.unLogin();
        //complete();
    }
}
