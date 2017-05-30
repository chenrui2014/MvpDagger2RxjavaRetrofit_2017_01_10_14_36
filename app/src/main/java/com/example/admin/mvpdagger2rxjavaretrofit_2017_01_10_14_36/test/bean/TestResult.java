package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.test.bean;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.bean.BaseListResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.bean.BaseResult;

import java.util.List;

/**
 * Created by 90678 on 2017/5/18.
 */

public class TestResult extends BaseListResult<TestResult.TestItem> {

    @Override
    public List<TestItem> getList() {
        return null;
    }

    public static class TestItem {

    }
}
