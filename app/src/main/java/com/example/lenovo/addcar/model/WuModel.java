package com.example.lenovo.addcar.model;

import android.util.Log;

import com.example.lenovo.addcar.bean.WuBean;
import com.example.lenovo.addcar.inter.Inters;
import com.example.lenovo.addcar.utils.RetrofitUnitl;

import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/21.
 */

public class WuModel {
    WuScuMod wuScuMod;

    public void setWuScuMod(WuScuMod wuScuMod) {
        this.wuScuMod = wuScuMod;
    }
    //自己定义一个请求方法
    public void WuSucces(){
        //OkHttp里面可以添加拦截器
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance("http://120.27.23.105/",ok)
                .setCreate(Inters.class)
                .getGou(98)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WuBean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(WuBean bean) {
                        wuScuMod.WuMScus(bean);
                        Log.e("==========",bean.toString());
                    }
                });
    }
    //定义一个接口
    public interface WuScuMod{
        void WuMScus(WuBean bean);
    }
}
