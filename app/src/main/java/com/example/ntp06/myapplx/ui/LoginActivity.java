package com.example.ntp06.myapplx.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ntp06.myapplx.R;
import com.example.ntp06.myapplx.sqlite.UserDAOService;
import com.why.tools.activity.BaseActivity;
import com.why.tools.utils.ToastUtils;

public class LoginActivity extends BaseActivity {

    EditText usernameEt;
    EditText passwordEt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected String getTitleStr() {
        return "登录";
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean success =  UserDAOService.getInstance().login(usernameEt.getText().toString().trim(),
                        passwordEt.getText().toString().trim());
                ToastUtils.showShortToast(LoginActivity.this, success ? "登录成功" : "登录失败");
                if(success) {
                    finish();
                }
            }
        });

        usernameEt = findViewById(R.id.et_zh);
        passwordEt = findViewById(R.id.et_mm);
    }
}
