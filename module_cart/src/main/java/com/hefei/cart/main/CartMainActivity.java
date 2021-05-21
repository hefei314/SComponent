package com.hefei.cart.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hefei.cart.databinding.CartActivityMainBinding;
import com.hefei.common.base.BaseBindingActivity;
import com.orhanobut.logger.Logger;

@Route(path = "/cart/MainActivity")
public class CartMainActivity extends BaseBindingActivity<CartActivityMainBinding> {

    @Override
    protected void initViews() {
        Logger.e("CartMainActivity");
    }

    @Override
    protected void updateViews() {

    }
}
