package com.cforce.huang.android.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cforce.huang.android.R;
import com.cforce.huang.android.utils.NetworkUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * NetworkUtils
 * Created by huang on 2016/9/26.
 */
public class NetWorkActivity extends BaseActivity {


    @BindView(R.id.setting)
    Button setting;
    @BindView(R.id.net_able)
    Button netAble;
    @BindView(R.id.net_connected)
    Button netConnected;
    @BindView(R.id.net_is_4g)
    Button netIs4g;
    @BindView(R.id.net_is_wifi)
    Button netIsWifi;
    @BindView(R.id.net_type)
    Button netType;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_network;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.setting, R.id.net_able, R.id.net_connected, R.id.net_is_4g, R.id.net_is_wifi, R.id.net_type})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting:
                NetworkUtils.openWirelessSettings(NetWorkActivity.this);
                break;
            case R.id.net_able:
                Toast.makeText(NetWorkActivity.this, ""+NetworkUtils.isAvailable(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.net_connected:
                Toast.makeText(NetWorkActivity.this, ""+NetworkUtils.isConnected(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.net_is_4g:
                Toast.makeText(NetWorkActivity.this, ""+NetworkUtils.is4G(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.net_is_wifi:
                Toast.makeText(NetWorkActivity.this, ""+NetworkUtils.isWifiConnected(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.net_type:
                Toast.makeText(NetWorkActivity.this, ""+NetworkUtils.getNetWorkTypeName(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
        }
    }
}
