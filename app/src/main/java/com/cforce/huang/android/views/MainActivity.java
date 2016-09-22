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
        ImageUtils.loadImg(this, "http://imgsrc.baidu.com/forum/pic/item/91ef76c6a7efce1b4b724a5eaf51f3deb58f65cd.jpg", imgHead);
    }
}
