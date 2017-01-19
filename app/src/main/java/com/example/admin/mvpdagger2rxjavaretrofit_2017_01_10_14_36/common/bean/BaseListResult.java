package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.bean;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/18 13:43 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/18 13:43 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseListResult<ITEM> extends BaseLoadingResult {

    public abstract List<ITEM> getList();
}
