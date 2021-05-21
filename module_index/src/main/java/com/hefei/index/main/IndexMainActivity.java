package com.hefei.index.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hefei.common.base.BaseBindingActivity;
import com.hefei.index.databinding.IndexActivityMainBinding;
import com.orhanobut.logger.Logger;

@Route(path = "/index/MainActivity")
public class IndexMainActivity extends BaseBindingActivity<IndexActivityMainBinding> {

    @Override
    protected void initViews() {
        Logger.e("IndexMainActivity");
    }

    @Override
    protected void updateViews() {

    }
}
