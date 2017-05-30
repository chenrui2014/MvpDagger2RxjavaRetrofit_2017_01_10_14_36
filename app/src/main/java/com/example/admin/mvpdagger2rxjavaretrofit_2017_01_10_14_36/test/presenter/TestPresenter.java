package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.presenter;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BaseListPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseListStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailListBean;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.bean.TestResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.component.DaggerTestApiComponent;

/**
 * Created by 90678 on 2017/5/18.
 */

public class TestPresenter extends BaseListPresenter<TestResult.TestItem, TestResult> {

    public TestPresenter(BaseListStatus<TestResult.TestItem> baseListStatus, BaseLoadingStatus<TestResult> baseLoadingStatus) {
        super(baseListStatus, baseLoadingStatus);

        DaggerTestApiComponent.builder().build().inject(this);
    }
}
