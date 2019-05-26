package com.pocs.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MeuIntentService extends IntentService {

    public MeuIntentService() {
        super("MeuIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int delay = 1000;
        int interval = 1000;
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Log.i("SERVICE", "RODANDO");
            }
        }, delay, interval);
    }
}