package com.wzk.modulardemo;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.wzk.modular.common.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpActivity("shop/MainActivity");
            }
        }, 2000);

    }
}
