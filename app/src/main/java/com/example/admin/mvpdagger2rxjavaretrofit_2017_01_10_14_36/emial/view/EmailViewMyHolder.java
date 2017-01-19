package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/19 11:25 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/19 11:25 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class EmailViewMyHolder extends ViewHolder {
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

    public EmailViewMyHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}