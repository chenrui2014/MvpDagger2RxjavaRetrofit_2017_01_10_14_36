package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.R;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BaseLoadingPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseLoadingStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.rx.RxFragment;

import static com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.R.id.srl;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/11 19:01 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/11 19:01 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseSwipeRefreshFragment<T, P extends BaseLoadingPresenter<T>>
        extends RxFragment implements BaseLoadingStatus<T> {

    public abstract P getPresenter();

    SwipeRefreshLayout mSrl;

    public SwipeRefreshLayout getSrl() {
        return mSrl;
    }

    public void setSrl(SwipeRefreshLayout srl) {
        mSrl = srl;
    }

    protected void setSwipeRefreshEnable(SwipeRefreshLayout srl, boolean enable) {
        if (srl != null) {
            srl.setEnabled(enable);
        }
    }

    protected void setSwipeRefreshEnable(boolean enable) {
        SwipeRefreshLayout srl = getSrl();
        if (srl != null) {
            srl.setEnabled(enable);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        View swipeRefreshView = addSwipeRefreshView(inflater, container, savedInstanceState);
        return super.onCreateView(inflater, (ViewGroup) swipeRefreshView, savedInstanceState);
    }

    private View addSwipeRefreshView (LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        View swipeView = inflater.inflate(R.layout.layout_swipe_refresh, null);
        mSrl = (SwipeRefreshLayout) swipeView.findViewById(srl);
        mSrl.addView(container);
        mSrl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
        setSwipeRefreshEnable(getSrl(), false);
        return swipeView;
//        return container;
    }

    @Override
    public void complete() {
        if (mSrl != null) {
            mSrl.setRefreshing(false);
        }
    }
}
