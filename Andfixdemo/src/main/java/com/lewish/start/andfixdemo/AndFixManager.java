package com.lewish.start.andfixdemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

/**
 * author: sundong
 * created at 2017/7/12 15:46
 */
public class AndFixManager {
    private static PatchManager patchManager = null;

    private AndFixManager() {

    }

    private static class SingletonHolder {
        private static final AndFixManager INSTANCE = new AndFixManager();
    }

    public static AndFixManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        patchManager = new PatchManager(context.getApplicationContext());
        patchManager.init(getVersionName(context.getApplicationContext()));//current version
        patchManager.loadPatch();
    }

    public static String getVersionName(Context context) {
        String versionName = "1.0.0";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public void addPatch(String path) {
        try {
            if (patchManager != null) {
                patchManager.addPatch(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
