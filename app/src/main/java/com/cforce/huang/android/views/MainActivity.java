package com.cforce.huang.android.views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cforce.huang.android.R;
import com.cforce.huang.android.utils.ImageUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tx_title)
    TextView txTitle;
    @BindView(R.id.btn_new)
    Button btnNew;
    @BindView(R.id.img_head)
    ImageView imgHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Logger.d("MainActivity");
    }

    @OnClick(R.id.btn_new)
    public void btnNew() {
        Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show();
        Logger.i("btnNew Onclick");
        ImageUtils.loadImg(this, "http://b.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=726677f8530fd9f9a0425d6d101df81c/f703738da97739122a85dde5fa198618377ae297.jpg", imgHead);
    }
}
