package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.emailService;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.emial.bean.EmailBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/28 18:42 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/28 18:42 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface MailApiService {

    //邮件列表
    @GET("api/MailSendList")
    Observable<EmailBean.Email> mailList(@Query("MinId") String minid,
                                   @Query("PageSize") int pageSize);
}
