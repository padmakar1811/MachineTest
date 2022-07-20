package com.machinetest.activity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.machinetest.constants.BaseActivity;
import com.machinetest.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         binding.btnStartChat.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(!TextUtils.isEmpty(binding.editName.getText().toString()))
                 {
                     goToActivityWithFinish(context, ConnectionActivity.class,null);
                 }
                 else
                 {
                     showMessage("Enter Your Name");
                 }
             }
         });
    }
}