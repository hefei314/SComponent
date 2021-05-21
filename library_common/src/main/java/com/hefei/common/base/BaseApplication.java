package com.hefei.common.base;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.hefei.common.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;

/**
 * <pre>
 *     author: hefei
 *     time  : 2021/05/21
 *     desc  :
 * </pre>
 */
public class BaseApplication extends MultiDexApplication {

    private static BaseApplication application;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initLogger();

        initARouter();

        initAutoSize();

        Utils.init(application);
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());
        }
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
    }

    private void initAutoSize() {
        //当 App 中出现多进程, 并且您需要适配所有的进程, 就需要在 App 初始化时调用 initCompatMultiProcess()
        AutoSize.initCompatMultiProcess(this);
        //让框架支持自定义 Fragment 的适配参数
        AutoSizeConfig.getInstance().setCustomFragment(true);
    }

    public static BaseApplication getApplication() {
        return application;
    }
}
