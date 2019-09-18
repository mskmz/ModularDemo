package com.wzk.modular.common;


import android.app.Application;
import android.util.Log;

import com.wzk.modular.arouter.annotation.model.RouterBean;
import com.wzk.modular.common.utils.Cons;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目父Application
 */
public class BaseApplication extends Application {
    private Map<String, RouterBean> map;
    private static BaseApplication baseApplication;

    public Map<String, RouterBean> getArouter() {
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }

    public static final BaseApplication getInstance() {
        return baseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Cons.TAG, "common/BaseApplication");
        baseApplication = this;
    }
}
