package com.why.tools.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.why.tools.R;

public abstract class BaseActivity extends AppCompatActivity {


    TextView titleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (0 != getLayoutId()) {
            ImageView backIv = findViewById(R.id.tool_bar_back);
            if (null != backIv) {
                backIv.setOnClickListener(view -> BaseActivity.super.onBackPressed());
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
    }

    /**
     *
     */
    protected void setImmersionBar(int statusBarColor) {
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (applyImmersionBar() || applyFullScreen()) {
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
