package com.smiling.gitapitest.base;

/**
 * 作者：labbol
 * 日期：2019/01/25
 * 描述：Persenter实现类
 */
public class IPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {

    }
}
