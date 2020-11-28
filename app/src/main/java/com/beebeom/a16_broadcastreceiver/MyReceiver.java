package com.beebeom.a16_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public static final String MY_BROADCAST = "응~내방송이야~";

    @Override
    public void onReceive(Context context, Intent intent) {
        //전원 연결 방송
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "전원 연결됨", Toast.LENGTH_SHORT).show();
        }else if (intent.getAction().equals(MY_BROADCAST)){
            Toast.makeText(context, "응~내 방송이야~", Toast.LENGTH_SHORT).show();
        }
    }
}