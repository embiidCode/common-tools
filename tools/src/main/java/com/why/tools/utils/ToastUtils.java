package com.why.tools.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

/**
 * 自定义Toast
 */
public class ToastUtils {
    private static Toast toast;

    private ToastUtils() {
    }

    public static void showShortToast(Context context,int resId) {
        showToast(context, resId, Toast.LENGTH_SHORT);
    }

    public static void showShortToast(Context context,CharSequence msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showLongToast(Context context,CharSequence msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }

    public static void showLongToast(Context context,int resId) {
        showToast(context, resId, Toast.LENGTH_LONG);
    }

    private static void showToast(Context context, CharSequence msg, int duration) {
        try {
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            if (toast != null) {
                toast.cancel();
            }
            toast = new Toast(context);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setText(msg);
            toast.setDuration(duration);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showToast(Context context, int resId, int duration) {
        try {
            if (resId == 0) {
                return;
            }
            if (toast != null) {
                toast.cancel();
            }
            toast = new Toast(context);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setText(resId);
            toast.setDuration(duration);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}