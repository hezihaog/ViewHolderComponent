package com.hzh.view.holder.component.sample.holder;

import android.content.Context;
import android.view.ViewGroup;

import com.hzh.view.holder.component.BaseListViewHeaderHolder;
import com.hzh.view.holder.component.sample.R;

/**
 * Package: com.hzh.view.holder.component.sample.holder
 * FileName: ListUseHeaderHolder
 * Date: on 2017/11/27  下午10:54
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class ListUseHeaderHolder extends BaseListViewHeaderHolder {
    public ListUseHeaderHolder(Context context) {
        super(context);
    }

    public ListUseHeaderHolder(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    public int onLayoutId() {
        return R.layout.holder_list_use_header;
    }
}
