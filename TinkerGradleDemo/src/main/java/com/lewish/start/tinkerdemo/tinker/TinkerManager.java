package com.lewish.start.tinkerdemo.tinker;

import android.content.Context;

import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * author: sundong
 * created at 2017/7/14 14:32
 */
public class TinkerManager {
    private static boolean mIsInstalled = false;
    private static ApplicationLike mApplicationLike;

    /**
     * 完成Tinker初始化
     *
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike) {
        mApplicationLike = applicationLike;
        if (mIsInstalled) {
            return;
        }
        LoadReporter loadReporter = new DefaultLoadReporter(getApplicationContext());
        PatchReporter patchReporter = new DefaultPatchReporter(getApplicationContext());
        DefaultPatchListener defaultPatchListener = new DefaultPatchListener(getApplicationContext());
        AbstractPatch upgradePatchProcessor = new UpgradePatch();

        TinkerInstaller.install(applicationLike);
//        TinkerInstaller.install(applicationLike,
//                loadReporter,
//                patchReporter,
//                defaultPatchListener,
//                CustomResultService.class,
//                upgradePatchProcessor); //完成Tinker初始化
        mIsInstalled = true;
    }

    /**
     * 加载Patch文件
     *
     * @param path
     */
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    private static Context getApplicationContext() {
        if (mApplicationLike != null) {
            return mApplicationLike.getApplication().getApplicationContext();
        }
        return null;
    }
}
