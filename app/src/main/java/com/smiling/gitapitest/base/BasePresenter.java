package com.smiling.gitapitest.base;

/**
 * 作者：Eg.song
 * 日期：2019/01/25
 * 描述：Presenter接口类
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

}
