package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.rx.RxFragment;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/10 16:39 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/10 16:39 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseLoadingFragment<T> extends RxFragment implements BaseLoadingStatus<T> {

    @Override
    public void loadData() {

    }

    @Override
    public void startLoad() {

    }

    @Override
    public void loading() {

    }

    @Override
    public void success(T data) {
        complete();
    }

    @Override
    public void failure(int code, String msg) {
        complete();
    }

    @Override
    public void error(String msg) {
        complete();
    }

    @Override
    public void complete() {

    }

    @Override
    public void reLoad() {

    }

    @Override
    public void offLine() {

    }

    @Override
    public void unLogin() {

    }
}
