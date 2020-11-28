package com.beebeom.a16_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyReceiver mMyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MyReceiver 객체 초기화
        mMyReceiver = new MyReceiver();

        //클릭시 방송 송출
        findViewById(R.id.btn_my_broadcast).setOnClickListener(v -> {
            Intent intent = new Intent(MyReceiver.MY_BROADCAST);
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //인텐트 필터로 거름망 만들어주기
        IntentFilter filter = new IntentFilter();
        //전원 연결 필터
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        //방송 만들기
        filter.addAction(MyReceiver.MY_BROADCAST);
        //등록
        registerReceiver(mMyReceiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //등록 해지
        unregisterReceiver(mMyReceiver);
    }
}