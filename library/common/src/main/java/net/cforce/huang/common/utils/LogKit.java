package net.cforce.huang.common.utils;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * 日志工具类
 * Created by huang on 2016/9/29.
 */
public class LogKit {

    public static boolean DEBUG = false;

    public static void init(boolean debug){
        DEBUG = debug;
        if (DEBUG) {
            Logger.init().logLevel(LogLevel.FULL);
        } else {
            Logger.init().logLevel(LogLevel.NONE);
        }
    }

    public static void d(String msg){
        if (DEBUG) {
            Logger.d(msg);
        }
    }

    public static void e(String msg) {
        if (DEBUG) {
            Logger.e(msg);
        }
    }

    public static void i(String msg) {
        if (DEBUG) {
            Logger.i(msg);
        }
    }

    public static void v(String msg) {
        if (DEBUG) {
            Logger.v(msg);
        }
    }

    public static void w(String msg) {
        if (DEBUG) {
            Logger.w(msg);
        }
    }

    public static void wtf(String msg) {
        if (DEBUG) {
            Logger.wtf(msg);
        }
    }

    public static void json(String msg) {
        if (DEBUG) {
            Logger.json(msg);
        }
    }

    public static void xml(String msg) {
        if (DEBUG) {
            Logger.xml(msg);
        }
    }


}
