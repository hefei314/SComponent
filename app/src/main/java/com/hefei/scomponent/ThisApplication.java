package com.hefei.scomponent;

import com.blankj.utilcode.util.Utils;
import com.hefei.common.base.BaseApplication;

/**
 * <pre>
 *     author: hefei
 *     time  : 2021/05/17
 *     desc  :
 * </pre>
 */
public class ThisApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        initConfig();
    }

    private void initConfig() {

        initDatabase();

        initHttp();

    }

    private void initDatabase() {

    }

    private void initHttp() {

    }
}
