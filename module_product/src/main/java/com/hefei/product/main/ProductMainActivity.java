package com.hefei.product.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hefei.common.base.BaseBindingActivity;
import com.hefei.product.databinding.ProductActivityMainBinding;
import com.orhanobut.logger.Logger;

@Route(path = "/product/MainActivity")
public class ProductMainActivity extends BaseBindingActivity<ProductActivityMainBinding> {

    @Override
    protected void initViews() {
        Logger.e("ProductMainActivity");
    }

    @Override
    protected void updateViews() {

    }
}
