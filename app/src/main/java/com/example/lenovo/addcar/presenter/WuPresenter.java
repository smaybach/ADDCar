package com.example.lenovo.addcar.presenter;

import com.example.lenovo.addcar.bean.WuBean;
import com.example.lenovo.addcar.model.WuModel;
import com.example.lenovo.addcar.view.IWuView;

import java.lang.ref.WeakReference;

/**
 * Created by lenovo on 2017/12/21.
 */

public class WuPresenter implements WuModel.WuScuMod {
    WeakReference<IWuView> view;
    WuModel model;

    public WuPresenter(IWuView view) {
        attach(view);
        model = new WuModel();
        model.setWuScuMod(this);
    }
    @Override
    public void WuMScus(WuBean bean) {
        view.get().onWuSucss(bean);
    }
    //我们在写一个方法拿到我们的请求
    public void  ShowPerWu(){
        model.WuSucces();
    }
    //绑定
    public void attach(IWuView views){
        view = new WeakReference(views);
    }
    //解绑方法
    public void detach(){
        view.clear();
    }
}

