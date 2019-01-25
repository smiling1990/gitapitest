package com.smiling.gitapitest.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：Eg.Song
 * 时间：2019/01/24
 * 描述：Activity基类
 */
public abstract class BaseActivity<T extends BasePresenter>
        extends AppCompatActivity implements BaseView {

    protected T mPresenter;
    protected Activity mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化布局
        setContentView(initLayout());
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        //初始化Presenter
        mPresenter = initPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        //Activity管理
        MyApplication.getInstance().addActivity(this);
        //初始化数据
        initDataAndView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        mUnBinder.unbind();
        MyApplication.getInstance().removeActivity(this);
    }

    protected abstract T initPresenter();

    protected abstract int initLayout();

    protected abstract void initDataAndView();


}
