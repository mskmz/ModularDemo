package com.wzk.modulardemo.demo;

import com.wzk.modular.arouter.annotation.model.RouterBean;
import com.wzk.modular.arouter.api.core.ARouterLoadPath;

import java.util.HashMap;
import java.util.Map;

//不考虑缓存性能 先以实现为主
public class Arout$$path$$root$$shop implements ARouterLoadPath {
    @Override
    public Map<String, RouterBean> loadPath() {
        Map<String, RouterBean> map = new HashMap<>();

        map.put("shop/MainActivity",
                RouterBean
                        .builder()
                        .setClazz(com.wzk.modular.shop.MainActivity.class)
                        .setPath("shop/MainActivity")
                        .setGroup("shop")
                        .setType(RouterBean.Type.ACTIVITY)
                        .build());
        return map;
    }
}
