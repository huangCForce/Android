package com.cforce.huang.android.views;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cforce.huang.android.R;
import com.cforce.huang.android.utils.NetworkUtils;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

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
    @BindView(R.id.requestBtn)
    Button requestBtn;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_network;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.setting, R.id.net_able, R.id.net_connected, R.id.net_is_4g, R.id.net_is_wifi, R.id.net_type, R.id.requestBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting:
                NetworkUtils.openWirelessSettings(NetWorkActivity.this);
                break;
            case R.id.net_able:
                Toast.makeText(NetWorkActivity.this, "" + NetworkUtils.isAvailable(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.net_connected:
                Toast.makeText(NetWorkActivity.this, "" + NetworkUtils.isConnected(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.net_is_4g:
                Toast.makeText(NetWorkActivity.this, "" + NetworkUtils.is4G(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.net_is_wifi:
                Toast.makeText(NetWorkActivity.this, "" + NetworkUtils.isWifiConnected(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.net_type:
                Toast.makeText(NetWorkActivity.this, "" + NetworkUtils.getNetWorkTypeName(NetWorkActivity.this), Toast.LENGTH_LONG).show();
                break;
            case R.id.requestBtn:

                new Thread(networkTask).start();


                break;
        }
    }

    public static final String API_URL = "https://api.github.com";
    public static class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(String login, int contributions) {
            this.login = login;
            this.contributions = contributions;
        }
    }
    public interface GitHub {
        @GET("/repos/{owner}/{repo}/contributors")
        Call<List<Contributor>> contributors(
                @Path("owner") String owner,
                @Path("repo") String repo);
    }

    Runnable networkTask = new Runnable() {
        @Override
        public void run() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // Create an instance of our GitHub API interface.
            GitHub github = retrofit.create(GitHub.class);

            // Create a call instance for looking up Retrofit contributors.
            Call<List<Contributor>> call = github.contributors("square", "retrofit");

            // Fetch and print a list of the contributors to the library.
            List<Contributor> contributors = null;
            try {
                contributors = call.execute().body();
                for (Contributor contributor : contributors) {
                    Logger.d(contributor.login + " (" + contributor.contributions + ")");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
