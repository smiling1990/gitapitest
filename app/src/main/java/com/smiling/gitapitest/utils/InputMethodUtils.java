package com.smiling.gitapitest.utils;

import android.content.Context;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 作者：EG.Song
 * 日期：2019/01/25
 * 描述：输入框
 */
public class InputMethodUtils {

    /**
     * 关闭输入框
     */
    public static void hideSoftInputFrom(Context mContext, EditText et) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(et.getApplicationWindowToken(), 0);
        }
    }

}
