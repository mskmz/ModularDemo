package com.wzk.modular.shop;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.wzk.modular.arouter.annotation.ARouter;
import com.wzk.modular.common.BaseActivity;

@ARouter()
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_main);
        jumpActivity("user/MainActivity");
    }
}
