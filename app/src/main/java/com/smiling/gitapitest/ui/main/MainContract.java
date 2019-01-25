package com.smiling.gitapitest.ui.main;

import com.smiling.gitapitest.base.BaseView;
import com.smiling.gitapitest.bean.TopicsBean;

/**
 * 作者：Eg.Song
 * 时间：2019/01/25
 * 描述：连接Presenter和View
 */
public class MainContract {

    interface MainView extends BaseView{

        void loadDateFromNetSuccess(TopicsBean bean);

    }

}
