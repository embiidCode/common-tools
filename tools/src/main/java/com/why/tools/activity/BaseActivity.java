package com.why.tools.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.why.tools.R;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 沉浸式状态栏
     */
    protected ImmersionBar immersionBar;

    TextView titleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (0 != getLayoutId()) {
            ImageView backIv = findViewById(R.id.tool_bar_back);
            if (null != backIv) {
                backIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BaseActivity.super.onBackPressed();
                    }
                });
            }

            if(!TextUtils.isEmpty(getTitleStr())) {
                titleTv = findViewById(R.id.tool_bar_title);
                if(null != titleTv) {
                    titleTv.setText(getTitleStr());
                }
            }
        }

        //是否全屏
        if (applyFullScreen()) {
            setFullScreenModel();
        }
        //是否设置沉浸式状态栏
        if (applyImmersionBar()) {
            setImmersionBar(getStatusBarColor());
        }

        init(savedInstanceState);
        initViews(savedInstanceState);
        initData();
    }

    /**
     * 初始化
     */
    protected void init(Bundle savedInstanceState) {
    }

    /**
     * 初始化view
     */
    protected void initViews(Bundle savedInstanceState) {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    protected abstract int getLayoutId();

    protected abstract String getTitleStr();

    /**
     * 是否设置沉浸式状态栏
     *
     * @return
     */
    protected boolean applyImmersionBar() {
        return true;
    }

    /**
     * 是否设置全屏显示
     *
     * @return
     */
    protected boolean applyFullScreen() {
        return false;
    }

    /**
     * 全屏App内容填充状态栏
     */
    protected void setFullScreenModel() {
        immersionBar = ImmersionBar.with(this);
        immersionBar.keyboardEnable(false)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    /**
     * 解决软键盘与沉浸式状态冲突
     * 暂时还用不到
     */
    protected void setImmersionBarKeyboardEnable() {
        if (immersionBar != null) {
            immersionBar.keyboardEnable(true)
                    .init();
        }
    }

    /**
     * 设置系统statusBar颜色
     *
     * @param statusBarColor 状态栏颜色
     */
    protected void setImmersionBar(int statusBarColor) {
        setImmersionBar(statusBarColor, false);
    }

    /**
     * 设置系统statusBar颜色
     *
     * @param statusBarColor 状态栏颜色
     */
    protected void setImmersionBar(int statusBarColor, boolean keyboardEnable) {
        immersionBar = ImmersionBar.with(this);
        immersionBar.statusBarColor(statusBarColor)
                .keyboardEnable(keyboardEnable)
                .fitsSystemWindows(true)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (applyImmersionBar() || applyFullScreen()) {
            if (immersionBar != null) immersionBar.destroy();
        }
    }

    /**
     * 系统StatusBar颜色
     *
     * @return
     */
    protected int getStatusBarColor() {
        return android.R.color.transparent;
    }
}
