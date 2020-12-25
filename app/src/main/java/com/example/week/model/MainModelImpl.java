package com.example.week.model;


import com.example.week.contract.MainContract;
import com.example.week.utils.INetCallBack;
import com.example.week.utils.RetorfitUtils;

public class MainModelImpl implements MainContract.IMainModel {
    private MainContract.IMainPresenter presenter;

    public MainModelImpl(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getList(String url, INetCallBack<T> callBack) {
        presenter.listResult("成功");
        RetorfitUtils.getRetorfitUtils().get(url,callBack);
    }
}
