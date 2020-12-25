package com.example.week.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    public V iView;
    public M iModel;
    public void attachView(V v){
        this.iView = v;
    }

    public void detachView(){
        iView = null;
        iModel = null;
    }

    public abstract M getiModel();

}
