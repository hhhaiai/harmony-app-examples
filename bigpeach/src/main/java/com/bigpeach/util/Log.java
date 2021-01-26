package com.bigpeach.util;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class Log {

    private static HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00001, "app");

    public static void e(String message) {
        HiLog.error(label, message);
    }

    public static void e(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00010, tag);
        HiLog.error(label, message);
    }

    public static void e(int domain, String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, domain, tag);
        HiLog.error(label, message);
    }

    public static void d(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00010, tag);
        HiLog.info(label, message);
    }

    public static void v(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00010, tag);
        HiLog.info(label, message);
    }

    public static void i(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00010, tag);
        HiLog.info(label, message);
    }

    public static void w(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00010, tag);
        HiLog.warn(label, message);
    }

    public static void wtf(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00010, tag);
        HiLog.fatal(label, message);
    }
}
