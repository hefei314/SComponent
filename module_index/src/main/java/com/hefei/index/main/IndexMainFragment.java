package com.hefei.index.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hefei.common.base.BaseBindingFragment;
import com.hefei.index.databinding.IndexFragmentMainBinding;

/**
 * <pre>
 *     author: hefei
 *     time  : 2021/05/17
 *     desc  :
 * </pre>
 */
@Route(path = "/index/IndexFragment")
public class IndexMainFragment extends BaseBindingFragment<IndexFragmentMainBinding> {

    @Override
    protected void initViews() {
        binding.tv.setOnClickListener(v -> {
            ARouter.getInstance().build("/find/MainActivity").navigation();
        });
    }

    @Override
    protected void updateViews() {

    }

}
