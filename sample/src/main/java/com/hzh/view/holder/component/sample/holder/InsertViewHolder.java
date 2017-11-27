package com.hzh.view.holder.component.sample.holder;

import android.content.Context;
import android.view.ViewGroup;

import com.hzh.view.holder.component.BaseHolder;
import com.hzh.view.holder.component.sample.R;

/**
 * Package: com.hzh.view.holder.component.sample.holder
 * FileName: InsertViewHolder
 * Date: on 2017/11/27  下午10:48
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class InsertViewHolder extends BaseHolder {
    public InsertViewHolder(Context context) {
        super(context);
    }

    public InsertViewHolder(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    public int onLayoutId() {
        return R.layout.holder_insert_view;
    }
}
