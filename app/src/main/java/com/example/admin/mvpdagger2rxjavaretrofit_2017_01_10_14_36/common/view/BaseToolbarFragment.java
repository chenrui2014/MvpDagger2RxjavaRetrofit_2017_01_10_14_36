package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.R;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/10 14:59 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/10 14:59 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseToolbarFragment extends BaseFragment {

    Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater
//                , addToolbarView(inflater, container, savedInstanceState)
//                , savedInstanceState);

        ViewGroup viewGroup = addToolbarView(inflater, container, savedInstanceState);
        mToolbar = (Toolbar) viewGroup.findViewById(R.id.toolbar);
        return viewGroup;
    }

    private ViewGroup addToolbarView(LayoutInflater inflater, @Nullable ViewGroup container,
                                @Nullable Bundle savedInstanceState) {
        View toolbarLayout = inflater.inflate(R.layout.layout_toolbar, container, false);
        LinearLayout llContainer = (LinearLayout) toolbarLayout.findViewById(R.id.toolbar_content);
        llContainer.addView(container);
        return (ViewGroup) toolbarLayout;
    }

    protected void setToolbarVisiable(int visiable) {
        if (mToolbar != null) {
            mToolbar.setVisibility(visiable);
        }
    }
}
