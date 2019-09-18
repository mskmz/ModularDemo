package com.wzk.modulardemo.demo;

import com.wzk.modular.arouter.annotation.model.RouterBean;
import com.wzk.modular.arouter.api.core.ARouterLoadPath;

import java.util.HashMap;
import java.util.Map;

//不考虑缓存性能 先以实现为主
public class Arout$$path$$root$$user implements ARouterLoadPath {
    @Override
    public Map<String, RouterBean> loadPath() {
        Map<String, RouterBean> map = new HashMap<>();
        map.put("user/MainActivity",
                RouterBean
                        .builder()
                        .setClazz(com.wzk.modular.user.MainActivity.class)
                        .setPath("user/MainActivity")
                        .setGroup("user")
                        .setType(RouterBean.Type.ACTIVITY)
                        .build());
        return map;
    }
}
