package com.example.ntp06.myapplx.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.ntp06.myapplx.R;
import com.example.ntp06.myapplx.sqlite.UserDAOService;
import com.example.ntp06.myapplx.utils.ToastUtils;

public class RegisterActivity extends BaseActivity {

    EditText usernameEt;
    EditText passwordEt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected String getTitleStr() {
        return "注册";
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        usernameEt = findViewById(R.id.et_zhang);
        passwordEt = findViewById(R.id.et_mi);
    }

    @Override
    protected void initData() {
        super.initData();

        findViewById(R.id.bt_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 进行注册
                String resultStr = UserDAOService.getInstance().register(usernameEt.getText().toString().trim(),
                        passwordEt.getText().toString().trim(), 10, "男");
                ToastUtils.showShortToast(RegisterActivity.this, TextUtils.isEmpty(resultStr) ? "注册成功" : resultStr);
                if (TextUtils.isEmpty(resultStr)) {
                    finish();
                }

            }
        });
    }
}
