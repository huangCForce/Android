package com.cforce.huang.android.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cforce.huang.android.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MainActivity extends BaseActivity {


    @BindView(R.id.constrainlBtn)
    Button constrainlBtn;
    @BindView(R.id.networkBtn)
    Button networkBtn;
    @BindView(R.id.btn_screen)
    Button btnScreen;
    @BindView(R.id.btn_img)
    Button btnImg;
    @BindView(R.id.ptr_view)
    PtrClassicFrameLayout ptrFrame;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("MainActivity");

        ptrFrame.setLastUpdateTimeRelateObject(this);
        ptrFrame.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrame.refreshComplete();
                    }
                }, 1500);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return true;
            }
        });
    }

    @OnClick({R.id.constrainlBtn, R.id.networkBtn, R.id.btn_screen, R.id.btn_img})
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
            case R.id.btn_screen:
                Logger.d("ScreenActivity");
                it = new Intent(this, ScreenActivity.class);
                startActivity(it);
                break;
            case R.id.btn_img:
                Logger.d("ImageUtilsActivity");
                it = new Intent(this, ImageUtilsActivity.class);
                startActivity(it);
                break;
        }
    }

}
