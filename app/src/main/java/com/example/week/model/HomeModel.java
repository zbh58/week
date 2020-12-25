package com.example.week.model;


import com.example.week.contract.HomeContract;
import com.example.week.data.ItemBean;
import com.example.week.utils.INetCallBack;
import com.example.week.utils.RetrofitUtils;

public class HomeModel implements HomeContract.IHomeModel {
    private HomeContract.IHomePresenter presenter;

    public HomeModel(HomeContract.IHomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getHomeData(String url, INetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url, new INetCallBack<ItemBean>() {
            @Override
            public void onSuccess(ItemBean itemBean) {
                callBack.onSuccess((T) itemBean);
            }

            @Override
            public void onFail(String err) {
                callBack.onFail(err);
            }
        });
    }
}
