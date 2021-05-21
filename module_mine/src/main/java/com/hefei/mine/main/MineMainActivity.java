package com.hefei.mine.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hefei.common.base.BaseBindingActivity;
import com.hefei.mine.databinding.MineActivityMainBinding;
import com.orhanobut.logger.Logger;

@Route(path = "/mine/MainActivity")
public class MineMainActivity extends BaseBindingActivity<MineActivityMainBinding> {

    @Override
    protected void initViews() {
        Logger.e("MineMainActivity");
    }

    @Override
    protected void updateViews() {

    }
}
