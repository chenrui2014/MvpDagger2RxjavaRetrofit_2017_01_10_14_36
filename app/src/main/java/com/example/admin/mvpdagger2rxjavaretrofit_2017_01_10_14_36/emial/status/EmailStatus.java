package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.status;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseViewStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailContent;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailSendResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailUploadBean;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/12 14:47 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/12 14:47 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface EmailStatus<T> extends BaseViewStatus<T>{
    void uploadAttachResult(EmailUploadBean emailUpload);
    void mailSendResult(EmailSendResult emailSendResult);
    void sendMail(EmailContent emailContent);
}
