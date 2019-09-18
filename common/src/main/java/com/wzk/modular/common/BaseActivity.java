package com.wzk.modular.common;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wzk.modular.arouter.annotation.model.RouterBean;
import com.wzk.modular.arouter.api.core.ARouterLoadGroup;
import com.wzk.modular.arouter.api.core.ARouterLoadPath;
import com.wzk.modular.common.utils.Cons;

import java.util.HashMap;
import java.util.Map;


/**
 * 项目父Activity
 */
public class BaseActivity extends AppCompatActivity {
    //---------------DEBUG配置-------------------------------------------------------
    private static final String TAG = "BaseActivity>>>";
    private static final boolean DEBUG = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(Cons.TAG, "common/BaseActivity");

    }

    public void jumpActivity(String path) {
        //获取路径集合
        Application application = getApplication();
        Map<String, RouterBean> map;
        if (application instanceof BaseApplication) {
            map = ((BaseApplication) application).getArouter();
        } else {
            map = new HashMap<>();
        }
        if (map.get(path) == null) {

            String[] arouterStr = path.split("/");
            String group = arouterStr[0];

            if (group.length() <= 1) {
                throw new RuntimeException("路径无法被解析-" + path + " 错误的path格式");
            }

            ARouterLoadGroup loadGroup;
            //获取类加载器
            try {
                loadGroup = (ARouterLoadGroup) Class.forName(BuildConfig.AROUTER_PACKAGE + "." + "Arouter$$group$$" + group).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("路径无法被解析 -" + BuildConfig.AROUTER_PACKAGE + "." + "Arouter$$group$$" + group + "- 可能未注册入group");
            }
            //解析二级路径
            String sec = "root";
            if (arouterStr.length > 2) {
                sec = arouterStr[1];
            }
            try {
                ARouterLoadPath aRouterLoadPath = loadGroup.loadGroup().get(sec).newInstance();
                map.putAll(aRouterLoadPath.loadPath());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("路径无法被解析 -在 " + loadGroup.getClass().getSimpleName() + "中没有" + sec + "对应的路径 - 二级域名无法被解析(除root组外 其他组必须填写二级域名)");
            }
            if (map.get(path) == null) {
                throw new RuntimeException(path + "路径无法被解析 - 对应域名未被注册");
            }
        }
        try {
            if (DEBUG) Log.d(TAG, "jumpActivity: " + map.get(path).getClazz().toString());
            Intent intent = new Intent(this, map.get(path).getClazz());
            startActivity(intent);
        } catch (Exception e) {
            throw new RuntimeException(path + "跳转失误");
        }
    }
}
