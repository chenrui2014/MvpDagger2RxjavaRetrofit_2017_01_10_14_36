package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.rx;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.bean.BaseLoadingResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/17 11:31 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/17 11:31 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseLoadingSubscriber<T extends BaseLoadingResult> extends BaseSubscriber<T> {

    BaseLoadingStatus<T> mBaseLoadingStatus;

    public BaseLoadingSubscriber(BaseLoadingStatus<T> baseLoadingStatus) {
        mBaseLoadingStatus = baseLoadingStatus;
    }

    @Override
    public void onCompleted() {
        mBaseLoadingStatus.complete();
    }

    @Override
    public void onError(Throwable e) {
        mBaseLoadingStatus.error(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        switch (t.getFlag()) {
            case 0:
                mBaseLoadingStatus.failure(0, t.getMsg());
                break;
            default:
                mBaseLoadingStatus.success(t);
                break;
        }
    }
}
