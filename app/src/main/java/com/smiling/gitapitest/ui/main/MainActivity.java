package com.smiling.gitapitest.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.utils.StringUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.smiling.gitapitest.R;
import com.smiling.gitapitest.base.BaseActivity;
import com.smiling.gitapitest.base.MyDividerLine;
import com.smiling.gitapitest.bean.TopicsBean;
import com.smiling.gitapitest.utils.InputMethodUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：Eg.Song
 * 时间：2019/01/24
 * 描述：主页UI
 */
public class MainActivity extends BaseActivity<MainPresenter>
        implements MainContract.MainView {

    @BindView(R.id.et_main)
    EditText mEtKey;
    @BindView(R.id.rv_main)
    RecyclerView mRecyclerView;
    @BindView(R.id.smart_main)
    SmartRefreshLayout mReflush;
    @BindView(R.id.pb_main)
    ProgressBar progressBar;

    //数据
    private int CUR_PAGE = 1;
    private MainRvAdapter mAdapter;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDataAndView() {
        //初始化SmartRefreshLayout
        initSmartView();
        //初始化RecyclerView
        initRecyclerView();
        //输入框
        mEtKey.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if ((actionId == 0 || actionId == 3) && keyEvent != null) {
                    //点击搜索要做的操作
                    goToSearch();
                }
                return false;
            }
        });
    }

    /**
     * 初始化SmartRefreshLayout
     */
    private void initSmartView() {
        //下拉刷新
        mReflush.setEnableRefresh(false);
        mReflush.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                CUR_PAGE = 1;
                mReflush.setEnableLoadMore(false);
                //从网络加载数据
                loadDataFromNet();
            }
        });
        //上拉加载
        mReflush.setEnableLoadMore(false);
        mReflush.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                CUR_PAGE++;
                //从网络加载数据
                loadDataFromNet();
            }
        });
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        //RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        //Adapter
        mAdapter = new MainRvAdapter(R.layout.item_recyclerview_main);
        mRecyclerView.setAdapter(mAdapter);
        //Divider Line
        MyDividerLine dividerLine = new MyDividerLine(MyDividerLine.HORIZONTAL);
        dividerLine.setSize(DensityUtil.dp2px(1.0f));
        dividerLine.setColor(getResources().getColor(R.color.lineRvColor));
        mRecyclerView.addItemDecoration(dividerLine);
    }

    /**
     * 加载网络数据
     */
    private void loadDataFromNet() {
        mPresenter.loadDataFromNet(mEtKey.getText().toString(), CUR_PAGE);
    }

    @OnClick({R.id.btn_search_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_search_main:
                //search
                goToSearch();
                break;
        }
    }

    /**
     * search
     */
    private void goToSearch() {
        if (StringUtils.isSpace(mEtKey.getText().toString())) {
            ToastUtils.showShortToast("Please input keyboards for searching topics.");
            return;
        }
        CUR_PAGE = 1;
        //隐藏输入框
        InputMethodUtils.hideSoftInputFrom(mContext, mEtKey);
        progressBar.setVisibility(View.VISIBLE);
        //加载数据的时候，停止刷新和加载更过
        mReflush.setEnableRefresh(false);
        mReflush.setEnableLoadMore(false);
        loadDataFromNet();
    }

    @Override
    public void loadDateFromNetSuccess(TopicsBean bean) {
        progressBar.setVisibility(View.GONE);
        mReflush.setEnableRefresh(true);
        if (CUR_PAGE == 1) {
            mAdapter.setNewData(bean.getItems());
            mReflush.finishRefresh();
        } else {
            mAdapter.addData(bean.getItems());
            mReflush.finishLoadMore();
            if (bean.getItems() != null && !bean.getItems().isEmpty()) {
                mReflush.setEnableLoadMore(true);
            }
        }
    }

    @Override
    public void showError(String msg) {
        progressBar.setVisibility(View.GONE);
        ToastUtils.showShortToast(msg);
    }
}
