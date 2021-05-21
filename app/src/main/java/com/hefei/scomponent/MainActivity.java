package com.hefei.scomponent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hefei.common.base.BaseBindingActivity;
import com.hefei.scomponent.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/app/MainActivity")
public class MainActivity extends BaseBindingActivity<ActivityMainBinding> {

    @Override
    protected void initViews() {

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
                binding.bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

        binding.bottomNavigationView.setItemIconTintList(null);
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    binding.viewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_category:
                    binding.viewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_find:
                    binding.viewPager.setCurrentItem(2);
                    break;
                case R.id.navigation_cart:
                    binding.viewPager.setCurrentItem(3);
                    break;
                case R.id.navigation_mine:
                    binding.viewPager.setCurrentItem(4);
                    break;
            }
            return false;
        });
    }

    @Override
    protected void updateViews() {

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