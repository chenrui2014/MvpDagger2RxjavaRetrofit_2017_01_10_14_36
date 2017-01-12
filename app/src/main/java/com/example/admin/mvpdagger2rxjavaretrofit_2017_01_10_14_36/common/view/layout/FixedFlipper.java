package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

public class FixedFlipper extends ViewFlipper {
    public FixedFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDetachedFromWindow(){
        try{
            super.onDetachedFromWindow();
        }catch(Exception e){
            super.stopFlipping();
        }
    }
}