package com.hefei.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

import com.hefei.common.R;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <pre>
 *     author: hefei
 *     time  : 2021/02/24
 *     desc  :
 * </pre>
 */
public abstract class BaseBindingActivity<T extends ViewBinding> extends AppCompatActivity {

    protected T binding;

    @Override
    protected void onStart() {
        super.onStart();
        initArguments();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Type superclass = getClass().getGenericSuperclass();
        Class<?> aClass = (Class<?>) ((ParameterizedType) superclass).getActualTypeArguments()[0];
        try {
            Method method = aClass.getDeclaredMethod("inflate", LayoutInflater.class);
            binding = (T) method.invoke(null, getLayoutInflater());
            setContentView(binding.getRoot());
            initViews();
            updateViews();
        } catch (Exception e) {
            throw new NullPointerException("ViewBinding is null");
        }
    }

    protected void initActionbar(boolean showHomeAsUp) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
    }

    protected void initActionbar(@StringRes int resTitle, boolean showHomeAsUp) {
        initActionbar(getString(resTitle), showHomeAsUp);
    }

    protected void initActionbar(CharSequence title, boolean showHomeAsUp) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title == null || title.length() == 0 ? getString(R.string.app_name) : title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
    }

    protected void initToolbar(Toolbar toolbar, boolean showHomeAsUp) {
        initToolbar(toolbar, getString(R.string.app_name), showHomeAsUp);
    }

    protected void initToolbar(Toolbar toolbar, @StringRes int resTitle, boolean showHomeAsUp) {
        initToolbar(toolbar, getString(resTitle), showHomeAsUp);
    }

    protected void initToolbar(Toolbar toolbar, String title, boolean showHomeAsUp) {
        toolbar.setTitle(title);
        if (toolbar.getNavigationIcon() == null) {
            toolbar.setNavigationIcon(R.drawable.icon_back);
        }
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void initArguments() {

    }

    protected abstract void initViews();

    protected abstract void updateViews();
}
