package com.machinetest.activity;

import android.os.Bundle;
import android.os.Handler;

import com.machinetest.R;
import com.machinetest.common.Utils;
import com.machinetest.constants.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToActivityWithFinish(context, LoginActivity.class,null);
            }
        }, Utils.SPLASHTIMEOUT);
    }
}