package com.hzh.view.holder.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView;

/**
 * ListView使用的ViewHolder
 */
public abstract class BaseListViewHeaderHolder extends BaseHolder {

    public BaseListViewHeaderHolder(Context context) {
        super(context);
    }

    public BaseListViewHeaderHolder(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    protected ViewGroup.LayoutParams onGetLayoutParams() {
        return new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}
