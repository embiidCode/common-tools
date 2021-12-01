package com.example.ntp06.myapplx.ui;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.ntp06.myapplx.R;

public class FamilyActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_family;
    }

    @Override
    protected String getTitleStr() {
        return "家人信息";
    }

    @Override
    protected void initData() {
        super.initData();
        if(null != titleTv) {
            if(null != getIntent()) {
                titleTv.setText(getIntent().getStringExtra("titleName"));
            }
        }

        findViewById(R.id.bt_ch_li).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
            }
        });
    }
}
