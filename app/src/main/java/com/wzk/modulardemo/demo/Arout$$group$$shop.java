package com.wzk.modulardemo.demo;

import com.wzk.modular.arouter.api.core.ARouterLoadGroup;
import com.wzk.modular.arouter.api.core.ARouterLoadPath;

import java.util.HashMap;
import java.util.Map;

public class Arout$$group$$shop implements ARouterLoadGroup {
    @Override
    public Map<String, Class<? extends ARouterLoadPath>> loadGroup() {
        Map<String, Class<? extends ARouterLoadPath>> map = new HashMap<>();
        map.put("shop", Arout$$path$$root$$shop.class);
        return map;
    }
}
