package com.pocs.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MeuReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intentService = new Intent(context, MeuIntentService.class);
        context.startService(intentService);

        Intent service = new Intent(context, MeuService.class);
        context.startService(service);
    }
}