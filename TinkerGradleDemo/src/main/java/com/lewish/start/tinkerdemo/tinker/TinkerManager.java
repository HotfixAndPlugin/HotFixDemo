package com.lewish.start.tinkerdemo.tinker;

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
    private static ApplicationLike mAppLike;

    /**
     * 完成Tinker初始化
     */
    public static void installTinker(ApplicationLike applicationLike) {
        mAppLike = applicationLike;
        if (mIsInstalled) {
            return;
        }
        LoadReporter loadReporter = new DefaultLoadReporter(mAppLike.getApplication());
        PatchReporter patchReporter = new DefaultPatchReporter(mAppLike.getApplication());
        DefaultPatchListener patchListener = new DefaultPatchListener(mAppLike.getApplication());
        AbstractPatch upgradePatchProcessor = new UpgradePatch();

        TinkerInstaller.install(applicationLike,
                loadReporter,
                patchReporter,
                patchListener,
                CustomResultService.class,
                upgradePatchProcessor);
        mIsInstalled = true;
    }

    /**
     * 加载Patch文件
     *
     * @param path
     */
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(mAppLike.getApplication(), path);
        }
    }
}
