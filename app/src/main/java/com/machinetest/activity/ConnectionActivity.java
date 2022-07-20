package com.machinetest.activity;


import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import com.machinetest.constants.BaseActivity;
import com.machinetest.databinding.ActivityConnectionBinding;

public class ConnectionActivity extends BaseActivity {

    ActivityConnectionBinding binding;
    String showIPaddress="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityConnectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        showIPaddress = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        binding.showIPtextId.setText(showIPaddress);

        binding.connectButton.setOnClickListener(view -> {
            if (Patterns.IP_ADDRESS.matcher(binding.ipEditText.getText()).matches()) {
                String info = getInfo();
                Intent intent = new Intent(ConnectionActivity.this, ChatActivity.class);
                intent.putExtra("ip&port", info);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(this, "Please Enter a Valid IP Address", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
    String getInfo() {
        String info = binding.ipEditText.getText().toString() + " " + binding.portEditText.getText().toString() + " " + binding.myPortEditText.getText().toString();
        return info;
    }
}