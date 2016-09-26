package com.cforce.huang.android.views;

import android.content.Intent;
import android.os.Bundle;
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


    @BindView(R.id.tx_title)
    TextView txTitle;
    @BindView(R.id.btn_new)
    Button btnNew;
    @BindView(R.id.index_4)
    ImageView index4;
    @BindView(R.id.index_1)
    ImageView index1;
    @BindView(R.id.index_7)
    ImageView index7;
    @BindView(R.id.index_3)
    ImageView index3;
    @BindView(R.id.index_5)
    ImageView index5;
    @BindView(R.id.index_0)
    ImageView index0;
    @BindView(R.id.index_2)
    ImageView index2;
    @BindView(R.id.index_6)
    ImageView index6;
    @BindView(R.id.index_8)
    ImageView index8;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.d("MainActivity");
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index0);
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index1);
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index2);
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index3);
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index4);
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index5);
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index6);
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index7);
        ImageUtils.loadImg(this, "https://huangcforce.github.io/img/myhead.jpg", index8);
    }

    @OnClick(R.id.btn_new)
    public void btnNew() {
        Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show();
        Logger.i("btnNew Onclick");
        Intent it = new Intent(this, ConstraintLayoutActivity.class);
        startActivity(it);
    }
}
