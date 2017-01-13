package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.BaseActivity;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.BaseLoadingFragment;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailBean;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailContent;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailSendResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailUploadBean;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.presenter.EmailPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.status.EmailStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/12 14:38 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/12 14:38 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class EmailActivity extends BaseActivity {
    @Override
    public Fragment getFragment() {
        return EmailFragment.newInstance();
    }

    public static class EmailFragment extends
            BaseLoadingFragment<EmailBean, EmailPresenter<EmailBean>> implements EmailStatus<EmailBean>{

        public static EmailFragment newInstance() {

            Bundle args = new Bundle();

            EmailFragment fragment = new EmailFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public EmailPresenter<EmailBean> getPresenter() {
            return new EmailPresenter<>(this, this);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
                , @Nullable Bundle savedInstanceState) {
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            getPresenter().loadData();
        }

        @Override
        public void fillView(EmailBean data) {

        }

        @Override
        public void uploadAttachResult(EmailUploadBean emailUpload) {

        }

        @Override
        public void mailSendResult(EmailSendResult emailSendResult) {

        }

        @Override
        public void sendMail(EmailContent emailContent) {

        }

    }
}
