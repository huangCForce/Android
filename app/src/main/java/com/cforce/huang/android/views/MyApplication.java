package com.cforce.huang.android.views;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.io.Serializable;


public class MyApplication extends Application implements Serializable {
	private static final long serialVersionUID = 1L;
	private static MyApplication mInstance;
	private static final String TAG = "CommunityApplication";

	private static final String ENABLE_APP_LOG = "ENABLE_APP_LOG";

	public static MyApplication getInstance() {
		return mInstance;
	}

	@Override
	public void onCreate() {
		mInstance = this;
		super.onCreate();

		mInstance = this;

	}


	@Override
	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}


	@Override
	public void onTerminate() {
		super.onTerminate();
	}

}
