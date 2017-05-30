package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseListStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailListBean.EmailList;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/18 15:50 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/18 15:50 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseListPresenter<ITEM, DATA>
        extends BaseLoadingPresenter<DATA> implements BaseListStatus<ITEM>{

    BaseListStatus<ITEM> mBaseListStatus;
    public BaseListPresenter(BaseListStatus<ITEM> baseListStatus, BaseLoadingStatus<DATA> baseLoadingStatus) {
        super(baseLoadingStatus);
        mBaseListStatus = baseListStatus;
    }

    @Override
    public void loadMore(ITEM data) {
        loading();
    }

    @Override
    public void getListData(List<ITEM> list) {

    }

    @Override
    public void getListMoreData(List<ITEM> list) {

    }

    @Override
    public void noMore() {

    }

    @Override
    public void hasMore() {

    }
}
