package com.example.week.contract;


import com.example.week.base.BaseModel;
import com.example.week.base.BaseView;
import com.example.week.utils.INetCallBack;

//TODO  契约类
public class HomeContract {
    public interface IHomeModel extends BaseModel {
        <T> void getHomeData(String url, INetCallBack<T> callBack);
    }
    public interface IHomePresenter{
        void Home(String url);
    }
    public interface IHomeView extends BaseView {
        <T> void HomeRelt(T t);
    }
}
