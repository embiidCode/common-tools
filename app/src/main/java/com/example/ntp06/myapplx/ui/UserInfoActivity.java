package com.example.ntp06.myapplx.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ntp06.myapplx.R;

public class UserInfoActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_userinfo;
    }

    @Override
    protected String getTitleStr() {
        return "用户信息";
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);

        findViewById(R.id.but_qi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FamilyActivity.class);
                intent.putExtra("titleName","妻子");
                startActivity(intent);
            }
        });

        findViewById(R.id.but_en).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FamilyActivity.class);
                intent.putExtra("titleName","儿女");
                startActivity(intent);
            }
        });

        findViewById(R.id.but_lr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FamilyActivity.class);
                intent.putExtra("titleName","老人");
                startActivity(intent);
            }
        });
    }
}
