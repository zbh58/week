package com.example.week.presenter;


import com.example.week.base.BasePresenter;
import com.example.week.bean.DatBean;
import com.example.week.contract.MainContract;
import com.example.week.model.MainModelImpl;
import com.example.week.utils.INetCallBack;

public class MainPresenterImpl extends BasePresenter implements MainContract.IMainPresenter {
    private final MainModelImpl model;
    private MainContract.IMainView mainView;

    public MainPresenterImpl(MainContract.IMainView mainView) {
        this.mainView = mainView;
        model = new MainModelImpl(this);
    }

    @Override
    public void getList() {
        model.getList("Girl/page/3/count/10", new INetCallBack<DatBean>() {
            @Override
            public void onSuccess(DatBean datBean) {
                mainView.getList(datBean);
            }

            @Override
            public void onFail(String error) {
                mainView.onFail(error);
            }
        });
    }

    @Override
    public void listResult(String result) {

    }
}
