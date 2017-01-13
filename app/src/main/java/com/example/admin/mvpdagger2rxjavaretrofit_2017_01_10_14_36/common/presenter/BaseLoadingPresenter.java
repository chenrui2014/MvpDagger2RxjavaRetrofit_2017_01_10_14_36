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
public class BaseLoadingPresenter<T> implements BaseLoadingStatus<T> {

    BaseLoadingStatus<T> mBaseLoadingStatus;

    public BaseLoadingPresenter(BaseLoadingStatus<T> baseLoadingStatus) {
        mBaseLoadingStatus = baseLoadingStatus;
    }

    @Override
    public void loadData() {
        mBaseLoadingStatus.loadData();
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
    public void success(T data) {
        mBaseLoadingStatus.success(data);
    }

    @Override
    public void empty() {
        mBaseLoadingStatus.empty();
    }

    @Override
    public void failure(int code, String msg) {
        mBaseLoadingStatus.failure(code, msg);
    }

    @Override
    public void error(String msg) {
        mBaseLoadingStatus.error(msg);
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
    }

    @Override
    public void unLogin() {
        mBaseLoadingStatus.unLogin();
    }
}
