package com.cforce.huang.android.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cforce.huang.android.R;

import net.cforce.huang.common.utils.ScreenUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ScreenUtils
 * Created by huang on 2016/9/26.
 */
public class ScreenActivity extends BaseActivity {

    @BindView(R.id.get_weight)
    Button getWeight;
    @BindView(R.id.get_height)
    Button getHeight;
    @BindView(R.id.hide_bar)
    Button hideBar;
    @BindView(R.id.get_bar_height)
    Button getBarHeight;
    @BindView(R.id.get_bar_status)
    Button getBarStatus;
    @BindView(R.id.show_notice)
    Button showNotice;
    @BindView(R.id.set_lan)
    Button setLan;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_screen;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.get_weight, R.id.get_height, R.id.hide_bar, R.id.get_bar_height, R.id.get_bar_status, R.id.show_notice, R.id.set_lan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_weight:
                Toast.makeText(ScreenActivity.this, ""+ ScreenUtils.getScreenWidth(ScreenActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.get_height:
                Toast.makeText(ScreenActivity.this, ""+ ScreenUtils.getScreenHeight(ScreenActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.hide_bar:
//                ScreenUtils.hideStatusBar(ScreenActivity.this);
                break;
            case R.id.get_bar_height:
                Toast.makeText(ScreenActivity.this, ""+ ScreenUtils.getStatusBarHeight(ScreenActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.get_bar_status:
                Toast.makeText(ScreenActivity.this, ""+ ScreenUtils.isStatusBarExists(ScreenActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.show_notice:
                ScreenUtils.showNotificationBar(ScreenActivity.this, true);
                break;
            case R.id.set_lan:
                ScreenUtils.setLandscape(ScreenActivity.this);
                break;
        }
    }
}
