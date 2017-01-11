package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view;

import android.support.v4.app.Fragment;

import butterknife.ButterKnife;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/10 14:58 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/10 14:58 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseFragment extends Fragment {

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
