package com.machinetest.activity;



import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.machinetest.R;
import com.machinetest.constants.BaseActivity;
import com.machinetest.databinding.ActivityMainBinding;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

public class ChatActivity extends BaseActivity{

    ActivityMainBinding binding;
    String TAG = "CLIENT ACTIVITY";

    String serverIpAddress = "";
    int myport;
    int sendPort;
    ArrayList<Message> messageArray;
    ImageButton fileUp;
    chatServer s;
    fileServer f;
    String ownIp;
    Toolbar toolbar;
    private Boolean exit = false;
    private RecyclerView mMessageRecycler;
    private ChatAdapterRecycler mMessageAdapter;
    private int REQUEST_CODE = 200;
    TextView tv_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        messageArray = new ArrayList<>();
        mMessageRecycler = findViewById(R.id.message_list);
        mMessageAdapter = new ChatAdapterRecycler(this, messageArray);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setStackFromEnd(true);
        layoutManager.setSmoothScrollbarEnabled(true);

        mMessageRecycler.setLayoutManager(layoutManager);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String info = bundle.getString("ip&port");
            assert info != null;
            String[] infos = info.split(" ");
            serverIpAddress = infos[0];
            sendPort = Integer.parseInt(infos[1]);
            myport = Integer.parseInt(infos[2]);
        }
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        ownIp = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("Connection to " + serverIpAddress);

        if (!serverIpAddress.equals("")) {
            s = new chatServer(ownIp, this, getApplicationContext(), mMessageAdapter, mMessageRecycler, messageArray, myport, serverIpAddress);
            s.start();
            f = new fileServer(getApplicationContext(), mMessageAdapter, mMessageRecycler, messageArray, myport, serverIpAddress);
            f.start();
        }


        binding.ivsendmesaage.setOnClickListener(v -> {
            if (!binding.etMessagetext.getText().toString().isEmpty()) {
                ChatActivity.User user = new ChatActivity.User("1:" + binding.etMessagetext.getText().toString());
                user.execute();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Please write something", Toast.LENGTH_SHORT);
                toast.show();
            }
        });




    }


    private boolean permissionAlreadyGranted() {
        int result = ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE);

        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        return false;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);

    }






    @SuppressLint("StaticFieldLeak")

    public class User extends AsyncTask<Void, Void, String> {
        String msg;

        User(String message) {
            msg = message;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                String ipadd = serverIpAddress;
                int portr = sendPort;
                Socket clientSocket = new Socket(ipadd, portr);
                OutputStream outToServer = clientSocket.getOutputStream();
                PrintWriter output = new PrintWriter(outToServer);
                output.println(msg);
                output.flush();
                clientSocket.close();
                runOnUiThread(() -> binding.ivsendmesaage.setEnabled(false)
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
            return msg;
        }

        protected void onPostExecute(String result) {
            runOnUiThread(() -> binding.ivsendmesaage.setEnabled(true));
            Log.i(TAG, "on post execution result => " + result);
            StringBuilder stringBuilder = new StringBuilder(result);
            if (stringBuilder.charAt(0) == '1' && stringBuilder.charAt(1) == ':') {
                stringBuilder.deleteCharAt(0);
                stringBuilder.deleteCharAt(0);
                result = stringBuilder.toString();

                messageArray.add(new Message(result, 0, Calendar.getInstance().getTime()));
                mMessageRecycler.setAdapter(mMessageAdapter);
                binding.etMessagetext.setText("");
            }
        }


    }

}