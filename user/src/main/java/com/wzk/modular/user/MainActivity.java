package com.wzk.modular.user;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wzk.modular.arouter.annotation.ARouter;

@ARouter()
public class MainActivity extends AppCompatActivity {
    //---------------DEBUG配置-------------------------------------------------------
    private static final String TAG = "MainActivity>>>";
    private static final boolean DEBUG = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_main);
        if (DEBUG) Log.d(TAG, "onCreate: 跳转成功 ");
    }
}
