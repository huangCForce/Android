package com.cforce.huang.android.widget.pulltoRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {

    private OnScrollChangedListener mScrollChangedListener;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        if (mScrollChangedListener != null) {
            mScrollChangedListener.onScrollChanged(x, y, oldx, oldy);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener l) {
        mScrollChangedListener = l;
    }

    public interface OnScrollChangedListener {
        void onScrollChanged(int x, int y, int oldx, int oldy);
    }

}
