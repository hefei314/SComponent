package com.hefei.find.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hefei.common.base.BaseBindingActivity;
import com.hefei.find.databinding.FindActivityMainBinding;
import com.orhanobut.logger.Logger;

@Route(path = "/find/MainActivity")
public class FindMainActivity extends BaseBindingActivity<FindActivityMainBinding> {

    @Override
    protected void initViews() {
        Logger.e("FindMainActivity");
    }

    @Override
    protected void updateViews() {

    }
}
