package com.lewish.start.tinkerdemo.tinker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * author: sundong
 * created at 2017/7/14 14:40
 */
@DefaultLifeCycle(application = ".MyApplication", flags = ShareConstants.TINKER_ENABLE_ALL, loadVerifyFlag = false)
public class CustomTinkerLike extends ApplicationLike {
    public CustomTinkerLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        TinkerManager.installTinker(this);
    }
}
