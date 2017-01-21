package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.R;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.activity.BaseActivity;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.activity.BaseListFragment;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailListBean;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailListBean.EmailList;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.presenter.EmailPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.status.EmailStatus;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/12 14:38 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/12 14:38 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class EmailActivity2 extends BaseActivity {
    @Override
    public Fragment getFragment() {
        return EmailFragment.newInstance();
    }

    public static class EmailFragment extends
            BaseListFragment<EmailList, EmailListBean, EmailPresenter, EmailViewMyHolder2>
            implements EmailStatus<EmailListBean> {

        public static EmailFragment newInstance() {

            Bundle args = new Bundle();

            EmailFragment fragment = new EmailFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public EmailPresenter getPresenter() {
            return new EmailPresenter(this, this);
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
        protected EmailViewMyHolder2 createItemViewHolder(ViewGroup parent) {
            return new EmailViewMyHolder2(LayoutInflater.from(this.getContext()).inflate(R.layout.item_emial, parent, false));
        }

        @Override
        protected void bindItemViewHolder(EmailViewMyHolder2 holder, EmailList emailList, int position) {
            holder.mItemEmailTime.setText(emailList.getRecvTime());
            holder.mItemEmailTitle.setText(emailList.getTitle());
            holder.mBtnTop.setVisibility(View.GONE);
            holder.mBtnDelete.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
//                    getBaseList().remove(position);
//                    getBaseHFAdapter().notifyItemRemoved(position);
                }
            });
        }


//        @Override
//        protected MyHolderItem createItemViewHolder(ViewGroup parent) {
//            return new EmailViewMyHolder(LayoutInflater.from(this.getContext()).inflate(R.layout.item_emial, parent, false));
//        }

//        @Override
//        protected void bindItemViewHolder(ViewHolder holder, EmailList emailList, int position) {
//            ((EmailViewMyHolder) holder).mItemEmailTime.setText(emailList.getRecvTime());
//            ((EmailViewMyHolder) holder).mItemEmailTitle.setText(emailList.getTitle());
//            ((EmailViewMyHolder) holder).mBtnTop.setVisibility(View.GONE);
//            ((EmailViewMyHolder) holder).mBtnDelete.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    getBaseList().remove(position);
////                    getBaseHFAdapter().notifyItemRemoved(position);
//                }
//            });
//        }

        @Override
        protected void loadStartData() {
            getPresenter().loadData();
        }

        @Override
        protected void loadMoreData(EmailList emailList) {
            getPresenter().loadMore(emailList);
        }

        @Override
        public void fillView(EmailListBean data) {

        }

    }

    public static class EmailViewMyHolder2 extends ViewHolder {
        @Bind(R.id.item_email_title)
        TextView mItemEmailTitle;
        @Bind(R.id.item_email_time)
        TextView mItemEmailTime;
        @Bind(R.id.btnTop)
        Button mBtnTop;
        @Bind(R.id.btnUnRead)
        Button mBtnUnRead;
        @Bind(R.id.btnDelete)
        Button mBtnDelete;

        public EmailViewMyHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
