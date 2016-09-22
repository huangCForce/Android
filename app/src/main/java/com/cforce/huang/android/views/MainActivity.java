package com.cforce.huang.android.views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cforce.huang.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tx_title)
    TextView txTitle;
    @BindView(R.id.btn_new)
    Button btnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_new)
    public void btnNew() {
        Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show();
    }
}
