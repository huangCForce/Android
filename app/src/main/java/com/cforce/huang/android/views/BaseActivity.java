package com.cforce.huang.android.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 *
 * Created by huang on 2016/9/22.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getContentViewLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutId());

    }
}
