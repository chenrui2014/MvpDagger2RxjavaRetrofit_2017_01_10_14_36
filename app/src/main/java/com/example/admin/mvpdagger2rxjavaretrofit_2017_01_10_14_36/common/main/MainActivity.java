package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.R;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.BaseActivity;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.BaseTabFragment3;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.rx.RxFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Override
    public Fragment getFragment() {
        return MainFragment.newInstance();
    }

    public static class MainFragment extends RxFragment {

        @Bind(R.id.scroll_tab_fl)
        FrameLayout mScrollTabFl;
        @Bind(R.id.top_title_tv)
        TextView mTopTitleTv;
        @Bind(R.id.fab)
        FloatingActionButton mFab;

        public static MainFragment newInstance() {

            Bundle args = new Bundle();

            MainFragment fragment = new MainFragment();
            fragment.setArguments(args);
            return fragment;
        }

//        @Nullable
//        @Override
//        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
//                                 @Nullable Bundle savedInstanceState) {
//            return inflater.inflate(R.layout.activity_main, container, false);
//        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            View view = super
                    .onCreateView(inflater, (ViewGroup) inflater
                            .inflate(R.layout.layout_scroll_tab, container, false), savedInstanceState);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.scroll_tab_fl,
                    MyTabFragment.newInstance()).commit();
            ButterKnife.bind(this, view);
            return view;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            ButterKnife.unbind(this);
        }

        public static class MyTabFragment extends BaseTabFragment3 {

            public static MyTabFragment newInstance() {

                Bundle args = new Bundle();

                MyTabFragment fragment = new MyTabFragment();
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public List<ItemTab> getTabList() {
                List<ItemTab> tabList = new ArrayList<>();
                tabList.add(new ItemTab("scroll", ScrollFragment.newInstance()));
                tabList.add(new ItemTab("recycler", RecyclerFragment.newInstance()));
                return tabList;
            }
        }
    }
}
