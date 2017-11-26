package com.hzh.view.holder.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;

import com.hzh.view.holder.component.inter.LayoutCallback;

import java.io.Serializable;

/**
 * 拆解Activity或者Fragment中的View组件
 */
public abstract class BaseHolder implements LayoutCallback, Serializable, View.OnAttachStateChangeListener {
    protected View root;
    protected Context context;

    public BaseHolder(Context context) {
        this.context = context;
        initView();
    }

    public BaseHolder(Context context, ViewGroup parent) {
        //调用一个参数的构造方法，并且初始化
        this(context);
        parent.addView(getRoot(), onGetAddViewIndex(parent));
    }

    private void initView() {
        onLayoutBefore();
        root = View.inflate(context, onLayoutId(), null);
        //添加在视图中被添加、移除的监听
        root.addOnAttachStateChangeListener(this);
        //添加视图在Windows中焦点监听
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {
            addOnWindowFocusChangeListener();
        }
        root.setLayoutParams(onGetLayoutParams());
        onLayoutAfter();
    }

    /**
     * 从视图树中添加时回调
     *
     * @param view
     */
    @Override
    public void onViewAttachedToWindow(View view) {

    }

    /**
     * 从视图树中移除时回调
     *
     * @param view
     */
    @Override
    public void onViewDetachedFromWindow(View view) {

    }

    public <E extends View> E findView(int id) {
        return (E) root.findViewById(id);
    }

    /**
     * 添加视图在Windows中焦点监听，4.3以上有效
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void addOnWindowFocusChangeListener() {
        root.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                BaseHolder.this.onWindowFocusChanged(hasFocus);
            }
        });
    }

    /**
     * 插入到布局的位置，默认是最后，需要插入到布局不同位置时，可以重写
     *
     * @param parent
     * @return
     */
    protected int onGetAddViewIndex(ViewGroup parent) {
        return parent.getChildCount();
    }

    /**
     * 获取视图根布局
     *
     * @return
     */
    public View getRoot() {
        return root;
    }

    /**
     * 移除自己
     */
    public final void removeSelf() {
        if (root != null) {
            ViewParent parent = root.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(root);
            }
        }
    }

    protected ViewGroup.LayoutParams onGetLayoutParams() {
        return new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    /**
     * 焦点切换时回调
     *
     * @param hasFocus 是否获取焦点
     */
    protected void onWindowFocusChanged(boolean hasFocus) {

    }

    @Override
    public abstract int onLayoutId();

    @Override
    public void onLayoutBefore() {

    }

    @Override
    public void onLayoutAfter() {

    }
}
