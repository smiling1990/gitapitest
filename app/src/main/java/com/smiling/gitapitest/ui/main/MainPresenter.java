package com.smiling.gitapitest.ui.main;

import android.util.Log;

import com.blankj.utilcode.utils.StringUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.smiling.gitapitest.base.IPresenter;
import com.smiling.gitapitest.bean.TopicsBean;
import com.smiling.gitapitest.config.UrlConfig;
import com.smiling.gitapitest.utils.JsonUitl;

/**
 * 作者：Eg.Song
 * 时间：2019/01/25
 * 描述：加载网络数据
 */
public class MainPresenter extends IPresenter<MainContract.MainView> {

    /**
     * 加载网络数据
     */
    public void loadDataFromNet(String key, int page) {
        OkGo.<String>get(UrlConfig.GIT_SEARCH_TOPICS)
                .tag("topics")
                .cacheKey("topicscache")
                .headers("Accept", "application/vnd.github.mercy-preview+json")
                .params("q", String.format("%s+is:featured", key))
                .params("sort", "display_name")
                .params("order", "desc")
                .params("page", page)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String jsonString = response.body();
                        Log.e("-->>", "response" + jsonString);
                        if (StringUtils.isSpace(jsonString)) {
                            mView.showError("failed to load data from net.");
                            return;
                        }
                        TopicsBean bean = (TopicsBean) JsonUitl.stringToObject(jsonString, TopicsBean.class);
                        if (bean == null) {
                            mView.showError("failed to parse data from response body.");
                            return;
                        }

                        mView.loadDateFromNetSuccess(bean);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Log.e("-->>", "error:" + response.message());
                        mView.showError(response.message());
                    }
                });
    }
}
