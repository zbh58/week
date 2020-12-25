package com.example.week.contract;


import com.example.week.bean.DatBean;
import com.example.week.utils.INetCallBack;

public class MainContract {
    public interface IMainModel{
        <T> void getList(String url, INetCallBack<T> callBack);
    }

    public interface IMainPresenter{
        void getList();
        void listResult(String result);
    }

    public interface IMainView{
        void getList(DatBean datBean);
        void onFail(String error);
    }
}
