package com.hefei.scomponent.main;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hefei.common.base.BaseBindingActivity;
import com.hefei.common.widget.navigation.NavigationItem;
import com.hefei.scomponent.R;
import com.hefei.scomponent.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/app/MainActivity")
public class MainActivity extends BaseBindingActivity<ActivityMainBinding> {

    @Override
    protected void initViews() {

        initBottomNavigationView();

        initViewPager();
    }

    @Override
    protected void updateViews() {

    }

    private void initBottomNavigationView() {
        binding.bottomNavigationView.addNavigationItem(new NavigationItem(
                this,
                "首页",
                R.drawable.nav_home,
                R.drawable.nav_home_highlight,
                Color.parseColor("#212121"),
                Color.parseColor("#0057B7")));
        binding.bottomNavigationView.addNavigationItem(new NavigationItem(
                this,
                "分类",
                R.drawable.nav_category,
                R.drawable.nav_category_highlight,
                Color.parseColor("#212121"),
                Color.parseColor("#0057B7")));
        binding.bottomNavigationView.addNavigationItem(new NavigationItem(
                this,
                "发现",
                R.drawable.nav_find,
                R.drawable.nav_find_highlight,
                Color.parseColor("#212121"),
                Color.parseColor("#0057B7")));
        binding.bottomNavigationView.addNavigationItem(new NavigationItem(
                this,
                "购物车",
                R.drawable.nav_cart,
                R.drawable.nav_cart_highlight,
                Color.parseColor("#212121"),
                Color.parseColor("#0057B7")));
        binding.bottomNavigationView.addNavigationItem(new NavigationItem(
                this,
                "我的",
                R.drawable.nav_mine,
                R.drawable.nav_mine_highlight,
                Color.parseColor("#212121"),
                Color.parseColor("#0057B7")));

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(position
                -> binding.viewPager.setCurrentItem(position, false));
    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add((Fragment) ARouter.getInstance().build("/index/IndexFragment").navigation());
        fragments.add((Fragment) ARouter.getInstance().build("/product/CategoryFragment").navigation());
        fragments.add((Fragment) ARouter.getInstance().build("/find/FindFragment").navigation());
        fragments.add((Fragment) ARouter.getInstance().build("/cart/CartFragment").navigation());
        fragments.add((Fragment) ARouter.getInstance().build("/mine/MineFragment").navigation());

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(this, fragments);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.viewPager.setUserInputEnabled(false);
        binding.viewPager.setOffscreenPageLimit(fragments.size());
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.bottomNavigationView.setCurrentNavigationItem(position);
            }
        });
    }

    //------------------------------------FragmentStateAdapter------------------------------------//

    private static class ViewPagerAdapter extends FragmentStateAdapter {

        private List<Fragment> mFragments;

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> mFragments) {
            super(fragmentActivity);
            this.mFragments = mFragments;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragments == null ? 0 : mFragments.size();
        }
    }
}