package com.hefei.scomponent.splash;

import android.content.Intent;

import com.hefei.common.base.BaseBindingActivity;
import com.hefei.scomponent.databinding.ActivitySplashBinding;
import com.hefei.scomponent.main.MainActivity;

/**
 * <pre>
 *     author: hefei
 *     time  : 2021/06/15
 *     desc  :
 * </pre>
 */
public class SplashActivity extends BaseBindingActivity<ActivitySplashBinding> {

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
