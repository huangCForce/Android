package com.cforce.huang.android.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cforce.huang.android.R;
import com.cforce.huang.android.utils.ImageUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.constrainlBtn)
    Button constrainlBtn;
    @BindView(R.id.networkBtn)
    Button networkBtn;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("MainActivity");
    }

    @OnClick({R.id.constrainlBtn, R.id.networkBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.constrainlBtn:
                Logger.d("ConstraintLayoutActivity");
                Intent it = new Intent(this, ConstraintLayoutActivity.class);
                startActivity(it);
                break;
            case R.id.networkBtn:
                Logger.d("NetWorkActivity");
                it = new Intent(this, NetWorkActivity.class);
                startActivity(it);
                break;
        }
    }
}
