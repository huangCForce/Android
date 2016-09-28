package com.cforce.huang.android.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.cforce.huang.android.R;

/**
 * UIKit
 * Created by huang on 2016/9/28.
 */
public class UIKit {

    // ==================Toast 消息弹出==========================
    public static void ToastMsg(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }

    public static void ToastMsg(Context ctx, int msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示在屏幕中间的Dialog
     *
     * @param contentView        显示的dialog的内容
     * @param cancelable         按返回键dialog是否消失
     * @param cancelTouchOutside 点击dialog外部dialog是否消失
     */
    public static Dialog showDialog(Context ctx, View contentView, boolean cancelable, boolean cancelTouchOutside) {
        return showDialog(ctx, contentView, 0.7f, cancelable, cancelTouchOutside, true);
    }

    /**
     * 显示在屏幕中间的Dialog-默认不显示
     *
     * @param contentView        显示的dialog的内容
     * @param cancelable         按返回键dialog是否消失
     * @param cancelTouchOutside 点击dialog外部dialog是否消失
     */
    public static Dialog createDialog(Context ctx, View contentView, boolean cancelable, boolean cancelTouchOutside) {
        return showDialog(ctx, contentView, 0.7f, cancelable, cancelTouchOutside, false);
    }

    /**
     * 显示在屏幕中间的Dialog
     *
     * @param contentView        显示的dialog的内容
     * @param cancelable         按返回键dialog是否消失
     * @param cancelTouchOutside 点击dialog外部dialog是否消失
     */
    public static Dialog showDialog(Context ctx, View contentView, float dimAmount, boolean cancelable, boolean cancelTouchOutside, boolean isShow) {
        Dialog dialog = new Dialog(ctx, R.style.dlg_common);
        try {
            dialog.setContentView(contentView);
            dialog.setCancelable(cancelable);
            dialog.setCanceledOnTouchOutside(cancelTouchOutside);
            Window window = dialog.getWindow();
            if (window != null) {
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.dimAmount = dimAmount;
                window.setAttributes(lp);
                if (isShow)
                    dialog.show();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return dialog;
    }

    @SuppressWarnings("deprecation")
    public static PopupWindow createPopuwindow(LayoutInflater inflater, int resourceId, int style) {
        View pw_view = inflater.inflate(resourceId, null);
        PopupWindow pw = new PopupWindow(pw_view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        //设置背景
        pw.setBackgroundDrawable(new BitmapDrawable());
        //设置动画
//		pw.setAnimationStyle(style);

        return pw;
    }
}
