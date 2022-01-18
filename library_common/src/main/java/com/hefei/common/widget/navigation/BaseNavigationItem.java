package com.hefei.common.widget.navigation;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * <pre>
 *     author: hefei
 *     time  : 2021/06/04
 *     desc  : 导航项基类
 * </pre>
 */
public abstract class BaseNavigationItem extends LinearLayout {

    protected Context mContext;

    protected boolean isChecked = false;

    public BaseNavigationItem(Context context) {
        super(context);

        this.mContext = context;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public boolean isChecked() {
        return isChecked;
    }
}
