package com.troy_zh.scworld;

import com.alibaba.android.arouter.launcher.ARouter;
import com.troy_zh.commonlib.base.BaseApp;

/**
 * Author: taozhang16
 * Package: com.troy_zh.scworld
 * Date: 2020/5/11 20:36
 * Describe: TODO
 */
public class App extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        initArouter();
    }

    private void initArouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
