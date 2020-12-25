package com.example.week.presenter;


import com.example.week.base.BasePresenter;
import com.example.week.contract.HomeContract;
import com.example.week.data.ItemBean;
import com.example.week.model.HomeModel;
import com.example.week.utils.INetCallBack;

public class HomePresenter extends BasePresenter<HomeContract.IHomeView, HomeModel> implements HomeContract.IHomePresenter {

    @Override
    public void Home(String url) {
        iModel = new HomeModel(this);
        iModel.getHomeData(url, new INetCallBack<ItemBean>() {
            @Override
            public void onSuccess(ItemBean itemBean) {
                iView.HomeRelt(itemBean);
            }

            @Override
            public void onFail(String err) {
                iView.tips(err);
            }
        });
    }

    @Override
    public HomeModel getiModel() {
        return new HomeModel(this);
    }
}
