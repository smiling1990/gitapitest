package com.smiling.gitapitest.ui.main;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.smiling.gitapitest.R;
import com.smiling.gitapitest.bean.TopicsBean;

/**
 * 作者：Eg.Song
 * 时间：2019/01/25
 * 描述：Adapter
 */
public class MainRvAdapter extends BaseQuickAdapter<TopicsBean.ItemsBean, BaseViewHolder> {

    public MainRvAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, TopicsBean.ItemsBean item) {
        helper.setText(R.id.tv_item_main_displayname, item.getDisplay_name());
        helper.setText(R.id.tv_item_main_createdby, item.getCreated_by());
    }
}
