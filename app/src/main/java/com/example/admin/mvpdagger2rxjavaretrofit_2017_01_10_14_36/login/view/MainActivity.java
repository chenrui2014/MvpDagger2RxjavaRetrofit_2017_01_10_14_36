package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.R;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.main.RecyclerFragment;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.main.ScrollFragment;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.activity.BaseActivity;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.activity.BaseLoadingFragment;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.activity.BaseTabFragment3;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.view.EmailActivity;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.view.EmailActivity2;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.bean.LoginResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.login.presenter.LoginPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Override
    public Fragment getFragment() {
        return MainFragment.newInstance();
    }

    public static class MainFragment extends BaseLoadingFragment<LoginResult,
            LoginPresenter>{

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

        @Override
        public LoginPresenter getPresenter() {
            return new LoginPresenter(this);
        }

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
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
//            getPresenter().loadData();
            getPresenter().login();
            setSwipeRefreshEnable(false);
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            ButterKnife.unbind(this);
        }

        @Override
        public void success(LoginResult data) {
            super.success(data);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_more:
                startActivity(new Intent(this, EmailActivity.class));
                break;
            case R.id.menu_more2:
                startActivity(new Intent(this, EmailActivity2.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
