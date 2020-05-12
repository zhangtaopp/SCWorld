package com.troy_zh.commonlib.base;

import android.app.Application;
import android.content.Context;

/**
 * Author: taozhang16
 * Package: com.troy_zh.commonlib.base
 * Date: 2020/5/11 20:30
 * Describe: application基类
 */
public class BaseApp extends Application {
    protected static Context mContext = null;

    public static Context getContext() {
        return mContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = base;
    }
}
