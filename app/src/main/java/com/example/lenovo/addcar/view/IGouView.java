package com.example.lenovo.addcar.view;

import com.example.lenovo.addcar.bean.AddBean;
import com.example.lenovo.addcar.bean.GouBean;
import com.example.lenovo.addcar.bean.XiangBean;

/**
 * Created by lenovo on 2017/12/21.
 */

public interface IGouView {
    void onGou(GouBean bean);//购物车成功的方法
    void onAdd(AddBean bean);//添加购物车
    //详情界面成功
    void  onXiangSucss(XiangBean bean);
}
