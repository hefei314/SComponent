package com.hefei.mine.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hefei.common.base.BaseBindingFragment;
import com.hefei.mine.databinding.MineFragmentMainBinding;
import com.scwang.smart.refresh.footer.BallPulseFooter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.BezierRadarHeader;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.FalsifyHeader;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.header.TwoLevelHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

/**
 * <pre>
 *     author: hefei
 *     time  : 2021/05/17
 *     desc  :
 * </pre>
 */
@Route(path = "/mine/MineFragment")
public class MineMainFragment extends BaseBindingFragment<MineFragmentMainBinding> {

    @Override
    protected void initViews() {
        binding.smartRefreshLayout.setRefreshHeader(new ClassicsHeader(mContext));
        binding.smartRefreshLayout.setRefreshFooter(new BallPulseFooter(mContext));

        binding.smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        binding.smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    @Override
    protected void updateViews() {

    }
}
